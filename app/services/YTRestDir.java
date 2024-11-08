/**
 * @author: Zheyi Zheng - 40266266
 * Created: 2024/10/29
 * This is the YTRestDir class. It handles the API request to YouTube.
 */
package services;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class YTRestDir {

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/10/29
     * Dependency injection method for HttpURLConnection. Without this method the mock test will not work, it will trigger actual network requests.
     * @param uri a target URI
     * @return an HttpURLConnection instance connect to target uri.
     */
    protected HttpURLConnection getHttpURLConnection(URI uri) throws IOException {
        return (HttpURLConnection) uri.toURL().openConnection();
    }

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/10/29
     * In order to allow fetch data asynchronously. I created this class to return CompletionFuture<List<YTResponse>>.
     * This class essentially is just calling the searchVideos method with supplyAsync, enable users to call it concurrently without interfering with each other's results.
     * @return the CompletableFuture. Everyone calls it can access additional asynchronous methods like thenApply.
     */
    public CompletableFuture<List<YTResponse>> searchVideosAsynch(String keyword, String url, String maxResult) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return searchVideos(keyword, url, maxResult);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/10/29
     * Request 10 search result from YouTube by making GET request.
     * @param keyword keyword that user provided. Target uri that should be to YouTube. The number of the search result.
     * @return a list of YTResponse (processed by mapResponse).
     */
    public List<YTResponse> searchVideos(String keyword, String url, String maxResult) throws IOException {
        String API_KEY = "";
        String BASE_URL = "https://www.googleapis.com/youtube/v3/search";
        String MAX_RESULTS = (maxResult != null) ? maxResult : "10";
        String encodedKeyword = URLEncoder.encode(keyword, StandardCharsets.UTF_8.toString());
        String urlString = (url != null) ? url : BASE_URL + "?part=snippet&q=" + encodedKeyword + "&key=" + API_KEY + "&maxResults=" + MAX_RESULTS;

        try {
            URI uri = new URI(urlString);
            HttpURLConnection conn = getHttpURLConnection(uri);
            conn.setRequestMethod("GET");

            // Handle response code
            int responseCode = conn.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                // If not 200, just throw an IOException
                throw new IOException("HTTP error code: " + responseCode);
            }

            // process the response
            try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                // Process input stream into a single string
                StringBuilder response = new StringBuilder();
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                // Apply the mapResponse to the string and return
                return mapResponse(response.toString());
            } catch (IOException e) {
                throw new IOException("Error reading response: " + e.getMessage());
            }
        } catch (URISyntaxException e) {
            throw new IOException("Invalid URL: " + e.getMessage());
        }
    }



    /**
     * @author: Pulkit Bansal - 40321488
     * Created: 2024/10/29
     * Fetch Details
     */

    public CompletableFuture<YTResponse> getVideoDetails(String videoId) {
        String API_KEY = "AIzaSyDauZHYK4DbMaQ5TUqU894bQF3LncD_TB0";
        String urlString = "https://www.googleapis.com/youtube/v3/videos?part=snippet&id=" + videoId + "&key=" + API_KEY;

        return CompletableFuture.supplyAsync(() -> {
            try {
                URI uri = new URI(urlString);
                HttpURLConnection conn = getHttpURLConnection(uri);
                conn.setRequestMethod("GET");

                int responseCode = conn.getResponseCode();
                if (responseCode != HttpURLConnection.HTTP_OK) {
                    throw new IOException("HTTP error code: " + responseCode);
                }

                try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                    StringBuilder response = new StringBuilder();
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    return parseVideoDetails(response.toString());
                }
            } catch (Exception e) {
                throw new RuntimeException("Error fetching video details: " + e.getMessage(), e);
            }
        });
    }

    /**
     * Helper method to parse JSON response and create a YTResponse object
     */
    public YTResponse parseVideoDetails(String jsonResponse) {
        JSONObject jsonObject = new JSONObject(jsonResponse);
        JSONArray items = jsonObject.getJSONArray("items");

        if (items.length() == 0) {
            return null; // No video found
        }

        JSONObject snippet = items.getJSONObject(0).getJSONObject("snippet");
        YTResponse ytResponse = new YTResponse();
        ytResponse.setTitle(snippet.getString("title"));
        ytResponse.setDescription(snippet.getString("description"));
        ytResponse.setChannelTitle(snippet.getString("channelTitle"));
        ytResponse.setChannelId(snippet.getString("channelId"));

        // Setting tags if they exist
        if (snippet.has("tags")) {
            List<String> tags = snippet.getJSONArray("tags").toList().stream()
                    .map(Object::toString)
                    .collect(Collectors.toList());
            ytResponse.setTags(tags);
        }
        return ytResponse;
    }


    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/10/29
     * Map json response into YTResponse.
     * @param jsonResponse a json response in String.
     * @return a list of YTResponse.
     */
    private List<YTResponse> mapResponse(String jsonResponse) {
        // Use JSONObject to retrieve information from response string
        JSONObject jsonObject = new JSONObject(jsonResponse);
        JSONArray items = jsonObject.getJSONArray("items");

        // Use Stream to map the response into YTResponse object
        return Stream.iterate(0, n -> n + 1)
                .limit(items.length())
                .map(n -> {
                    // For each json object, create a YTResponse instance and feed information into the instance.
                    JSONObject video = items.getJSONObject(n);
                    //System.out.println(video);
                    JSONObject snippet = video.getJSONObject("snippet");
                    YTResponse ytResponse = new YTResponse();
                    ytResponse.setTitle(video.getJSONObject("snippet").getString("title"));

                    JSONObject idObject = video.getJSONObject("id");
                    if (idObject.has("videoId")) {
                        ytResponse.setVideoId(idObject.getString("videoId"));
                        ytResponse.setVideoLink("https://www.youtube.com/watch?v=" + ytResponse.getVideoId());
                    } else {
                        // based on my test, result might contains playlist. If the response is not a video, use N/A as the Id and link
                        ytResponse.setVideoId("N/A");
                        ytResponse.setVideoLink("N/A");
                    }
                    ytResponse.setChannelTitle(video.getJSONObject("snippet").getString("channelTitle"));
                    ytResponse.setChannelId(video.getJSONObject("snippet").getString("channelId"));
                    ytResponse.setChannelProfileLink("https://www.youtube.com/channel/" + ytResponse.getChannelId());
                    ytResponse.setDescription(video.getJSONObject("snippet").getString("description"));
                    ytResponse.setThumbnailUrl(video.getJSONObject("snippet").getJSONObject("thumbnails").getJSONObject("default").getString("url"));
                    //System.out.println(ytResponse.toString());

                    if (snippet.has("tags")) {
                        List<String> tags = snippet.getJSONArray("tags").toList().stream()
                                .map(Object::toString)
                                .collect(Collectors.toList());
                        ytResponse.setTags(tags);
                    }


                    return ytResponse;
                })
                // collect all ytResponse into list
                .collect(Collectors.toList());
    }

}
