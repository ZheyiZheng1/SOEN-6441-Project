/**
 * @author: Zheyi Zheng - 40266266
 * Created: 2024/10/29
 * This is the YTRestDir class. It handles the API request.
 */
package services;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class YTRestDir {
    private static final String API_KEY = "";
    private static final String BASE_URL = "https://www.googleapis.com/youtube/v3/search";
    private static final String MAX_RESLUT = "10";
    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/10/29
     * Request 10 search result from YouTube by making GET request.
     * Return a list of YTResponse (processed by mapResponse).
     */
    public List<YTResponse> searchVideos(String keyword) throws IOException {
        //Set up the url to use the API_KEY and retrieve 10 results.
        String urlString = BASE_URL + "?part=snippet&q=" + keyword + "&key=" + API_KEY + "&maxResults=" + MAX_RESLUT;
        try {
            URI uri = new URI(urlString);
            HttpURLConnection conn = (HttpURLConnection) uri.toURL().openConnection();
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
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/10/29
     * Map json response into YTResponse.
     * Return a list of YTResponse.
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
                    return ytResponse;
                })
                // collect all ytResponse into list
                .collect(Collectors.toList());
    }

}
