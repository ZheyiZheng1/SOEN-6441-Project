package actors;

import akka.actor.*;
import akka.japi.*;
import actors.ProjectProtocol.*;
import services.ReadabilityService;
import services.YTResponse;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import akka.actor.AbstractActor;

/**
 * @author: Zheyi Zheng - 40266266
 * Created: 2024/11/12
 * This is the ReadabilityActor class. This class is responsible to take a search result and send back a ReadabilityService.
 */
public class ReadabilityActor extends AbstractActor {
    //Flesch Reading Ease Score
    List<Double> fre = new ArrayList<>();
    //Flesch-Kincaid Grade Level
    List<Double> fkgl = new ArrayList<>();

    Double avgFRE;
    Double avgFKGL;
    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/11/11
     * This is the getProps method. This method allows Props create APIActor.
     * @return Props Proper return object in Akka
     */
    public static Props getProps() {
        return Props.create(ReadabilityActor.class);
    }

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/11/11
     * This is the createReceive method. This method read search result from message and send ReadabilityService to requester.
     * @return Receive proper return object in Akka
     */
    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(ReadabilityCheck.class, message -> {
                    // Retrieve search result from message
                    CompletableFuture<List<YTResponse>> result = message.result;
                    // Create the ReadabilityService instance
                    ReadabilityService(result);
                    sender().tell(new ReadabilityResponse(fre, fkgl, avgFRE, avgFKGL), self());
                })
                .build();
    }

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/10/30
     * This is the Constructors method. This class method take a CompletableFuture<List<YTResponse>> and use thenApply to perform calculation.
     * Calculation inside thenApply are for fre and fkgl. All calculation and data processing are done by stream.
     * @param target should be the response of the YouTube
     */
    public void ReadabilityService(CompletableFuture<List<YTResponse>> target){
        // Process the input to get fre, fkgl and average readability
        target.thenAccept(list -> {
            List<Double> totalWords;
            List<Double> totalSentences;
            List<Double> totalSyl;

            // Use steam to count each description's total word number and collect as list of Integer. Assuming all words are separated by at least one whitespace.
            totalWords = list.stream()
                    .map(YTResponse::getDescription)
                    .map(sentence -> (double) sentence.trim().split("\\s+").length)
                    .collect(Collectors.toList());

            // Use steam to count each description's total sentences number and collect as list of Integer. Assuming all sentences end with . or ! or ?.
            totalSentences = list.stream()
                    .map(YTResponse::getDescription)
                    .map(sentence -> (double) sentence.trim().split("[.!?]+").length)
                    .collect(Collectors.toList());

            // Use steams to count each description's total syllable numbers. It first map to stream of String, then map to stream integers which each represent syllable number of that description.
            totalSyl = list.stream()
                    .map(YTResponse::getDescription)
                    .map(this::countSyllablesInDescription)
                    .map(Integer::doubleValue)
                    .collect(Collectors.toList());

            // Prepare the decimal format, this object round the result to 1 decimal place. Otherwise, it will not match with the result provided by the website.
            DecimalFormat df = new DecimalFormat("#.0");
            // Calculate FRE use provided formula. For each group of totalWords, totalSentences and totalSyl, perform the formula and add to the result list.
            IntStream.range(0, totalWords.size()).forEach(i -> {
                // Calculate and round the fre to one decimal place.
                this.fre.add(Double.parseDouble(df.format(206.835 - 1.015 * (totalWords.get(i)/totalSentences.get(i)) - 84.6*(totalSyl.get(i)/totalWords.get(i)))));
            });
            // Calculate FKGL use provided formula. Same logic with fre.
            IntStream.range(0, totalWords.size()).forEach(i -> {
                // Calculate and round the fkgl to one decimal place.
                this.fkgl.add(Double.parseDouble(df.format(0.39 * (totalWords.get(i)/totalSentences.get(i)) + 11.8*(totalSyl.get(i)/totalWords.get(i)) - 15.59)));
            });
        }).join();
        // Calculate the average readability using stream. map to double, take average, orElse 0.0 in case of the list is empty.
        avgFRE = fre.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
        avgFKGL = fkgl.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/10/30
     * This is the countSyllablesInDescription method.
     * This method use countSyllables to count all syllables in a description.
     * @param description, pass a description of a video.
     * @return an integer, represents number of syllables in provided description.
     *
     */
    private int countSyllablesInDescription(String description){
        return Arrays.stream(description.toLowerCase().split("\\s+"))
                .map(this::countSyllables)
                .mapToInt(Integer::intValue)
                .sum();
    }

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/10/30
     * This is the countSyllables method. This method just take a word and count Syllables
     * It returns an integer.
     * @param word in String.
     * @return an int that represents number of syllables in the word.
     */
    private int countSyllables(String word){
        AtomicBoolean prevWasVowel = new AtomicBoolean(false);
        return (int) Arrays.stream(word.toLowerCase().split(""))
                .filter(c -> {
                    boolean isVowel = c.matches("[aeiou]");
                    // Continues syllables count as one. for example, io in description, ee in deep.
                    boolean countThis = isVowel && !prevWasVowel.get();
                    prevWasVowel.set(isVowel);
                    return countThis;
                })
                .count();
    }
}
