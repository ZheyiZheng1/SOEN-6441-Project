package services;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
     * Added the seperate CompletetableFuture for MoreStat
     * Author: Praneet Avhad - 40279347
     * Created: 2024/11/05
     */

public class WordCountService {

    public CompletableFuture<List<YTResponse>> searchVideosAsync(String keyword, String url, String maxResult) throws IOException, NullPointerException {
        CompletableFuture<List<YTResponse>> futureResult = fetchDataAsync(keyword, url, maxResult);
        return futureResult;
    }
    public CompletableFuture<List<YTResponse>> fetchDataAsync(String keyword, String url, String maxResult) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                // Simulate a long-running task
                List<YTResponse> result = new YTRestDir().searchVideos(keyword, url, maxResult);
                //Thread.sleep(2000);  // 2-second delay
                return result;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });
    }
}
