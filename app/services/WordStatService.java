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

public class WordStatService extends Controller {
    private static final List<String> SKIPWORDS = Arrays.asList(
            "a", "an", "and", "are", "as", "at", "be", "by", "for", "from", "has", "he",
            "in", "is", "it", "its", "of", "on", "that", "the", "to", "was", "were", "will",
            "with", "i", "you", "she", "we", "they", "my", "your", "this", "these", "those",
            "or", "but", "if", "because", "just","s","t"
    );

    public Map<String, Long> getWordFrequency(List<YTResponse> videos) {
        return videos.stream()
                // Extract words from each video's title or description
                .flatMap(video -> Stream.of((video.getTitle() + " " + video.getDescription()).split("\\W+"))) // Split by non-word characters
                .map(String::toLowerCase) // Convert to lowercase for case-insensitive counting
                .filter(word -> !word.isEmpty()) // Remove any empty words
                .filter(word -> word.length() > 1)           // Remove single-character words
                .filter(word -> !SKIPWORDS.contains(word))   // Remove unneccasary words
                .filter(word -> !word.matches("\\d+"))       // Remove numbers
                .collect(Collectors.groupingBy(word -> word, Collectors.counting())); // Count each word
    }

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


