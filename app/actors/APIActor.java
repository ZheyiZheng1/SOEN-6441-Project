package actors;

import akka.actor.*;
import actors.ProjectProtocol.*;
import org.json.JSONArray;
import org.json.JSONObject;
import services.YTResponse;
import services.YTRestDir;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author: Zheyi Zheng - 40266266
 * Created: 2024/11/14
 * This is the APIAcotr class. This class is responsible to make API call to YouTube.
 */
public class APIActor extends AbstractActor{
    // Create YTRestDir
    private static YTRestDir ytRestDir;

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/11/14
     * This is the getProps method. This method allows Props create APIActor.
     * @return Props Proper return object in Akka
     */
    public static Props getProps() {
        return Props.create(APIActor.class);
    }

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/11/14
     * This is the createReceive method. This method distinguish messages.
     * If the message is KeyWordSearch class, then return a search result to requester. Else, do nothing.
     * @return Receive proper return object in Akka
     */
    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(KeyWordSearch.class, message -> {
                    // Retrieve keyword
                    String keyword = message.keyword;
                    String url = message.url;
                    String maxResult = message.maxResult;
                    // Retrieve search result using searchVideosAsynch method
                    try {
                        CompletableFuture<List<YTResponse>> result = searchVideosAsynch(keyword, url, maxResult);
                        // Send a message back to requester
                        sender().tell(result, self());

                    } catch (Exception e) {
                        // Error occurred, return an error message.
                        sender().tell(new ErrorMessage("An error occurred"), self());
                    }
                })
                .build();
    }
    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/11/14
     * Dependency injection method for HttpURLConnection. Without this method the mock test will not work, it will trigger actual network requests.
     * @param uri a target URI
     * @return an HttpURLConnection instance connect to target uri.
     */
    protected HttpURLConnection getHttpURLConnection(URI uri) throws IOException {
        return (HttpURLConnection) uri.toURL().openConnection();
    }

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/11/14
     * In order to allow fetch data asynchronously. I created this class to return CompletionFuture<List<YTResponse>>.
     * This class essentially is just calling the searchVideos method with supplyAsync, enable users to call it concurrently without interfering with each other's results.
     * @return the CompletableFuture. Everyone calls it can access additional asynchronous methods like thenApply.
     */
    public CompletableFuture<List<YTResponse>> searchVideosAsynch(String keyword, String url, String maxResult) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                return searchVideos(keyword, url, maxResult);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/11/14
     * Request 10 search result from YouTube by making GET request.
     * @param keyword keyword that user provided. Target uri that should be to YouTube. The number of the search result.
     * @return a list of YTResponse (processed by mapResponse).
     */
    public List<YTResponse> searchVideos(String keyword, String url, String maxResult) throws IOException, URISyntaxException {
        String API_KEY = "AIzaSyALS-NQwYqhQ0OmY5nTb88Jg0vpqEdoI-w";
        String BASE_URL = "https://www.googleapis.com/youtube/v3/search";
        String MAX_RESULTS = (maxResult != null) ? maxResult : "50";
        String encodedKeyword = URLEncoder.encode(keyword, StandardCharsets.UTF_8.toString());
        String urlString = (url != null) ? url : BASE_URL + "?part=snippet&q=" + encodedKeyword + "&key=" + API_KEY + "&maxResults=" + MAX_RESULTS;

        URI uri = new URI(urlString);
        HttpURLConnection conn = getHttpURLConnection(uri);
        conn.setRequestMethod("GET");

        // Handle response code
        int responseCode = conn.getResponseCode();

        // process the response
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        // Process input stream into a single string
        StringBuilder response = new StringBuilder();
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        // Apply the mapResponse to the string and return
        return mapResponse(response.toString());

    }
    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/11/14
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
