package actors;

import akka.actor.AbstractActor;
import akka.actor.Props;
import services.YTResponse;
import actors.ProjectProtocol.*;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class SentimentActor extends AbstractActor {
    String FinalOutput;

    /**
     * @author: Jiaxi Liu - 40278106
     * Created: 2024/11/24
     * The method creates an actors
     * @return SentimentActor
     */
    static public Props props() {
        return Props.create(SentimentActor.class);
    }

    /**
     * @author: Jiaxi Liu - 40278106
     * Created: 2024/11/24
     * If the method receives message of SentimentCheck.class, check the sentiment and return a message to SentimentResponse()
     */
    @Override
    public Receive createReceive() {
        return receiveBuilder().
                match(SentimentCheck.class, message->{
                    //check the sentiment
                    SentimentService(message.input);
                    //return a message to SentimentResponse()
                    sender().tell(new ProjectProtocol.SentimentResponse(this.getFinalOutput()),self());
                        })
                .match(SentimentUpdate.class,message->{
                    SentimentService(message.input);
                    sender().tell(new ProjectProtocol.SentimentUpdateResponse(this.getFinalOutput()),self());
                })
                .build();
    }

    /**
     * @author: Jiaxi Liu - 40278106
     * Created: 2024/11/6
     * The method calculates the rate of positive words and negative words, then generates the sentiment string(":-)",":-(",":-|")
     * @param Input  is the information of videos
     */
    public void SentimentService(CompletableFuture<List<YTResponse>> Input){
        Input.thenApply(list ->{

            List<Integer> tempTotalWords;
            Double totalWords;
            Double happyWords;
            Double sadWords;

            //calculate the number of all words in all descriptions by stream
            tempTotalWords = list.stream()
                    .map(YTResponse::getDescription)
                    .map(Description ->  Description.trim().split(" ").length)
                    .collect(Collectors.toList());

            totalWords = tempTotalWords.stream()
                            .map(num -> (double)num)
                            .reduce(0.0,Double::sum);

            //calculate the number of positive words in all descriptions by stream
            //First calculate the number of positive words in each video then add them together
            happyWords = list.stream()
                    .map(YTResponse::getDescription)
                    .map(Description -> Description.trim().split(" "))
                    .map(words -> (double)countHappyWords(words))
                    .reduce(0.0, Double::sum);

            //calculate the number of negative words in all descriptions by stream
            //First calculate the number of negative words in each video then add them together
            sadWords = list.stream()
                    .map(YTResponse::getDescription)
                    .map(Description -> Description.trim().split(" "))
                    .map(words -> (double)countSadWords(words))
                    .reduce(0.0, Double::sum);

            //if the rate of positive words is bigger than 0.7(70%),set the FinalOutput as ":-)"
            if(happyWords/totalWords >= 0.70)
                FinalOutput = ":-)";
                //if the rate of negative words is bigger than 0.7(70%),set the FinalOutput as ":-("
            else if (sadWords/totalWords >= 0.70)
                FinalOutput = ":-(";
                //If both of them are less than 0.7,set the FinalOutput as ":-|"
            else FinalOutput = ":-|";

            return null;
        });


    }

    /**
     * @author: Jiaxi Liu - 40278106
     * Created: 2024/11/6
     * The method is used to count the number of positive words in a single video description.
     * The method contains a list of positive words.
     * @param words is an array of words split from a video description.
     * @return NumOfHappyWord is the number of positive words.
     */
    public int countHappyWords(String[] words){
        List<String> listOfWords = Arrays.asList(words);
        String[] happyWords = {"happy", "joyful", "blissful", "cheerful", "satisfied", "delighted", "joy","affection", "fondness", "cherish", "touched", "attachment", "warmth", "deep affection",
                "motivated", "encouraged", "uplifted", "energized", "confident", "brave", "enthusiastic", "admiration", "respect", "praise", "appreciation", "reverence", "affirmation",
                "thankful", "grateful", "appreciative", "blessed", "content", "forgiving", "understanding", "comfortable", "relaxed", "ease", "carefree", "peaceful", "calm", "safe",
                "success", "achievement", "fulfilled", "pride", "pleased", "proud", "progress", "excitement", "thrilled", "eager", "surprised", "cheerful", "lively", "exhilarated",
                "optimistic", "hopeful", "confident", "positive", "reassured", "radiant", "gleeful", "buoyant", "jubilant", "elated", "inspired", "driven", "focused", "determined", "empowered",
                "fulfilled", "accomplished", "satisfied", "rewarded", "valued", "vibrant", "spirited", "dynamic", "animated", "energetic", "playful", "lighthearted", "amused", "entertained", "fun-loving",
                "compassionate", "empathetic", "caring", "kind-hearted", "supportive", "serene", "tranquil", "untroubled", "harmonious", "balanced", "grounded", "centered", "mindful", "aware", "present",
                "secure", "protected", "comforted", "assured", "safe", "open-minded", "accepting", "tolerant", "inclusive", "flexible", "curious", "inquisitive", "explorative", "adventurous", "engaged",
                "hopeful", "expectant", "looking forward", "anticipating", "excited", "charitable", "generous", "giving", "selfless", "thoughtful", "appreciated", "cherished", "loved", "adored", "treasured",
                "successful", "victorious", "celebrated", "honored", "noteworthy", "enlightened", "wise", "perceptive", "insightful", "knowledgeable", "whole", "complete", "unified", "aligned", "integrated",
                "playful", "youthful", "joyous", "sunny", "radiant"
        };

        long NumOfHappyWord = listOfWords.stream()
                .filter(word -> IfContain(word,happyWords))
                .count();

        return (int)NumOfHappyWord;
    }


    /**
     * @author: Jiaxi Liu - 40278106
     * Created: 2024/11/6
     * The method is used to count the number of negative words in a single video description.
     * The method contains a list of negative words.
     * @param words is an array of words split from a video description.
     * @return NumOfSadWord is the number of negative words.
     */
    public int countSadWords(String[] words){
        List<String> listOfWords = Arrays.asList(words);
        String[] sadWords = { "sad", "down", "depressed", "heartbroken", "lonely", "disappointed", "unhappy", "angry", "furious", "annoyed", "frustrated", "irritated", "resentful", "outraged",
                "afraid", "scared", "anxious", "worried", "nervous", "alarmed", "panicked", "disgusted", "revolted", "repulsed", "nauseated", "sickened", "offended", "appalled",
                "guilty", "ashamed", "remorseful", "regretful", "sorry", "blameworthy", "fault", "ashamed", "humiliated", "embarrassed", "disgraced", "self-conscious", "mortified",
                "disappointed", "discouraged", "let down", "disheartened", "dissatisfied", "regretful", "frustrated", "exasperated", "irritated", "stuck", "defeated", "helpless",
                "exhausted", "weary", "drained", "worn-out", "fatigued", "uneasy", "tense", "apprehensive", "restless", "agitated", "confused", "bewildered", "lost", "unsure",
                "uncertain", "hopeless", "despairing", "despondent", "discouraged", "downcast", "disheartened", "crestfallen", "low-spirited", "indifferent", "apathetic", "disinterested",
                "unenthusiastic", "ignored", "neglected", "unappreciated", "overlooked", "powerless", "vulnerable", "unsupported", "defenseless", "envious", "jealous", "resentful", "covetous",
                "bored", "disinterested", "unmotivated", "uninspired", "bitter", "spiteful", "grudging", "resentful", "isolated", "alienated", "excluded", "ostracized", "suppressed", "repressed",
                "restrained", "stifled", "empty", "hollow", "unfulfilled", "meaningless", "insecure", "inadequate", "inferior", "unworthy", "uneasy", "perturbed", "unsettled", "jittery", "fed up",
                "sick", "tired", "disenchanted", "controlled", "manipulated", "oppressed", "exploited", "agonized", "tortured", "tormented", "distressed", "shamed", "disgraced", "humiliated", "mortified"
        };

        long NumOfSadWord = listOfWords.stream()
                .filter(word -> IfContain(word,sadWords))
                .count();

        return (int)NumOfSadWord;
    }

    /**
     * @author: Jiaxi Liu - 40278106
     * Created: 2024/11/6
     * The method is used to estimate if a word is in the word list.
     * @param word is a word in description.
     * @param keywords is the word list of positive words or negative words.
     */
    boolean IfContain(String word,String[] keywords){
        return Arrays.stream(keywords).anyMatch(keyword -> keyword.contains(word));
    }


    /**
     * @author: Jiaxi Liu - 40278106
     * Created: 2024/11/6
     * The method is used to get the final output(a symbol of sentiment).
     * @return  FinalOutput.
     */
    public String getFinalOutput() {
        return FinalOutput;
    }


}
