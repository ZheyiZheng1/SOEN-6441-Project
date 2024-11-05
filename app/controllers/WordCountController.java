
package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import services.WordCountService;
import services.YTResponse;
import views.html.Home.videoStatistics;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
     * Added the new WordCount Controller for Word stat functionality.
     * Author: Praneet Avhad - 40279347
     * Created: 2024/11/05
     */

public class WordCountController extends Controller {
    public Map<String, Long> getWordFrequency(List<YTResponse> videos) {
        return videos.stream()
                // Extract words from each video's title or description
                .flatMap(video -> Stream.of((video.getTitle() + " " + video.getDescription()).split("\\W+"))) // Split by non-word characters
                .map(String::toLowerCase) // Convert to lowercase for case-insensitive counting
                .filter(word -> !word.isEmpty()) // Remove any empty words
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
    public Result videoStatistics(String keyword) throws ExecutionException, InterruptedException, IOException {
        CompletableFuture<List<YTResponse>> videosFuture = new WordCountService().searchVideosAsync(keyword,null, "50");
        //CompletableFuture<List<YTResponse>> videosFuture = getLatestVideos(keyword);
        List<YTResponse> videos = videosFuture.get();
        System.out.println(videos.get(0));
        Map<String, Long> wordFrequency = getWordFrequency(videos);
        Map<String, Long> sortedWordFrequency = sortWordsByFrequency(wordFrequency);
//        Map<String, Long> sortedWordFrequency = new LinkedHashMap<>();
//        sortedWordFrequency.put("test1", 45L);
//        sortedWordFrequency.put("test2", 45L);
//        sortedWordFrequency.put("test3", 45L);
//        sortedWordFrequency.put("test4", 45L);

        return ok(videoStatistics.render(sortedWordFrequency));
    }
}

