/**
 * @author: Praneet Avhad - 40279347
 * This is the word stat service.
 */


package services;

import play.mvc.Controller;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * WordStatService is a service class responsible for processing a list of YouTube response objects
 * and calculating word frequency statistics based on their titles and descriptions. It provides
 * functionality to extract words, filter unnecessary data, count word occurrences, and sort words
 * by frequency in descending order.
 *
 * This class includes two main methods:
 * 1. `getWordFrequency(List<YTResponse> videos)` - Extracts words from video titles and descriptions,
 *    filters them, and returns a map of word frequencies.
 * 2. `sortWordsByFrequency(Map<String, Long> wordFrequency)` - Sorts the word frequency map
 *    in descending order by frequency.
 *
 * @author Praneet Avhad - 40279347
 *
 * @param videos List of YouTube response objects (YTResponse), each containing a title and description.
 */


public class WordStatService extends Controller {
    // private static final List<String> SKIPWORDS = Arrays.asList(
    //         "a", "an", "and", "are", "as", "at", "be", "by", "for", "from", "has", "he",
    //         "in", "is", "it", "its", "of", "on", "that", "the", "to", "was", "were", "will",
    //         "with", "i", "you", "she", "we", "they", "my", "your", "this", "these", "those",
    //         "or", "but", "if", "because", "just","s","t"
    // );

    /**
     * Extracts words from the titles and descriptions of a list of YouTube response objects,
     * filters out empty words, single-character words, and numbers, and returns a map of
     * word frequencies.
     *
     * @param videos The list of YouTube response objects.
     * @return A map where the keys are words and the values are the count of occurrences of those words.
     * @throws IllegalArgumentException if the input list is null or empty.
     */
    
    public Map<String, Long> getWordFrequency(List<YTResponse> videos) {
        return videos.stream()
                // Extract words from each video's title or description
                .flatMap(video -> Stream.of((video.getTitle() + " " + video.getDescription()).split("\\W+"))) // Split by non-word characters
                .map(String::toLowerCase) // Convert to lowercase for case-insensitive counting
                .filter(word -> !word.isEmpty()) // Remove any empty words
                .filter(word -> word.length() > 1 || (word.length() == 1 && word.matches("[a-z]")))              // Remove single-character words
                //.filter(word -> !SKIPWORDS.contains(word))   // Remove unneccasary words
                .filter(word -> !word.matches("\\d+"))       // Remove numbers
                .collect(Collectors.groupingBy(word -> word, Collectors.counting())); // Count each word
    }

    /**
     * Sorts the word frequency map by frequency in descending order.
     * The sorted map maintains the order of words starting from the most frequent.
     *
     * @param wordFrequency A map containing word frequencies.
     * @return A map sorted by frequency in descending order.
     */
    public Map<String, Long> sortWordsByFrequency(Map<String, Long> wordFrequency) {
        return wordFrequency.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new // Maintain descending order
                ));
    }

}


