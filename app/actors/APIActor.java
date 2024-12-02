package actors;

import Model.FetchTags;
import Model.ChannelProfile;
import Model.TextSegment;
import akka.actor.*;
import actors.ProjectProtocol.*;
import ch.qos.logback.classic.Logger;
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
 * This is the APIActor class. This class is responsible for making API calls to YouTube
 *  * and processing requests such as video search and channel profile retrieval.
 */
public class APIActor extends AbstractActor{
    private static final String CHANNEL_URL ="https://www.googleapis.com/youtube/v3/search" ;
    private static final String API_KEY ="AIzaSyDCVMGmEoe4TviZVUHA4awhwqGMtgcR1wY" ;
    public static APIActor.ChannelProfileRequest ChannelProfileRequest;

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
                    // Perform normal search
                    // Retrieve keyword
                    String keyword = message.keyword;
                    String url = message.url;
                    String maxResult = message.maxResult;
                    // Retrieve search result using searchVideosAsynch method
                    try {
                        CompletableFuture<List<YTResponse>> result = searchVideosAsynch(keyword, url, maxResult);
                        // Send a simple message back to requester
                        sender().tell(result, self());

                    } catch (Exception e) {
                        // Error occurred, return an error message.
                        sender().tell(new ErrorMessage("An error occurred"), self());
                    }
                })
                .match(UpdateDataRequest.class, message -> {
                    // Received update request
                    // Retrieve keyword
                    String keyword = message.keyword;
                    String url = message.url;
                    String maxResult = message.maxResult;
                    // Retrieve search result using searchVideosAsynch method
                    try {
                        CompletableFuture<List<YTResponse>> result = searchVideosAsynch(keyword, url, maxResult);
                        // Send a UpdateDataResponse message back to requester
                        sender().tell(new UpdateDataResponse(result, keyword), self());

                    } catch (Exception e) {
                        // Error occurred, return an error message.
                        sender().tell(new ErrorMessage("An error occurred"), self());
                    }
                })
                //FetchTags logic handling
                .match(FetchTags.class, message -> {
                    //Fetching Tags
                    try{
                        CompletableFuture<List<TextSegment>> tags = searchVideosAsynch(message.keyword, null, null)
                                .thenApply(videos -> videos.stream()
                                        .flatMap(video -> video.getTags().stream())
                                        .distinct()
                                        .map(tag -> new TextSegment(tag, "/tagDetails?videoId=" + tag))
                                        .collect(Collectors.toList())
                                );
                        //sending these tags back as response
                        sender().tell(tags, self());
                    } catch (Exception e) {
                        sender().tell(new ErrorMessage("An error occurred while handling tags"), self());
                    }
                })
                .match(ChannelProfileRequest.class, request -> {
                    // Log the request for debugging
                    Logger log = (Logger) org.slf4j.LoggerFactory.getLogger(APIActor.class);
                    log.info("Received ChannelProfileRequest for channelId: {}", request.getChannelId());

                    // Fetch the channel profile asynchronously using YTRestDir
                    YTRestDir.getChannelProfile(request.getChannelId()).thenAccept(channelProfile -> {
                        // Log the fetched channel profile
                        log.info("Fetched Channel Profile: {}", channelProfile);

                        // Send the fetched channel profile back to the sender (likely WebSocketActor)
                        sender().tell(new ChannelProfileResponse(request.getChannelId(), channelProfile), self());
                    }).exceptionally(ex -> {
                        // Handle any exception during fetching
                        log.error("Error fetching channel profile: {}", ex.getMessage());
                        sender().tell(new ErrorMessage("An error occurred while fetching the channel profile"), self());
                        return null;
                    });
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
        String API_KEY = "AIzaSyDCVMGmEoe4TviZVUHA4awhwqGMtgcR1wY";
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
        return mapResponse(response.toString(), keyword);

    }
    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/11/14
     * Map json response into YTResponse.
     * @param jsonResponse a json response in String.
     * @return a list of YTResponse.
     */
    private List<YTResponse> mapResponse(String jsonResponse, String keyword) {
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
                    // New keyword feature added for later update.
                    ytResponse.setkeyword(keyword);
                    return ytResponse;
                })
                // collect all ytResponse into list
                .collect(Collectors.toList());
    }
    /**
     * @author: Sakshi Mulik - 40295793
     * Created: 2024/12/01
     * Requests the channel profile asynchronously for a given channel ID.
     *
     */

    private void ChannelProfileRequest(ChannelProfileRequest message) {
        String channelId = message.getChannelId();
        try {
            CompletableFuture<Object> profile = fetchChannelProfile(channelId);
            sender().tell(profile, self());
        } catch (Exception e) {
            sender().tell(new ErrorMessage("An error occurred while fetching the channel profile"), self());
        }
    }
    /**
     * @author: Sakshi Mulik - 40295793
     * Created: 2024/12/01
     * Fetches the channel profile asynchronously for a given channel ID.
     * @param channelId the YouTube channel ID to fetch the profile.
     * @return CompletableFuture<ChannelProfile> the future with the channel profile.
     */

    public CompletableFuture<Object> fetchChannelProfile(String channelId) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                String urlString = CHANNEL_URL + "?part=snippet,statistics&id=" + channelId + "&key=" + API_KEY;
                URI uri = new URI(urlString);
                HttpURLConnection conn = (HttpURLConnection) uri.toURL().openConnection();
                conn.setRequestMethod("GET");

                // Log the request URL and response code for debugging
                System.out.println("Request URL: " + urlString);
                int responseCode = conn.getResponseCode();
                System.out.println("Response Code: " + responseCode);

                if (responseCode != 200) {
                    throw new IOException("Failed to fetch channel profile: " + responseCode);
                }

                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder response = new StringBuilder();
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }

                // Log the response for debugging purposes
                System.out.println("Response Body: " + response.toString());

                return mapChannelProfileResponse(response.toString());
            } catch (Exception e) {
                System.err.println("Error fetching channel profile: " + e.getMessage());
                throw new RuntimeException("Error fetching channel profile: " + e.getMessage(), e);
            }
        });
    }

    /**
     * @author: Sakshi Mulik - 40295793
     * Created: 2024/12/01
     * Maps the API response to a ChannelProfile object.
     * @param jsonResponse raw JSON response from YouTube API.
     * @return ChannelProfile the channel profile object.
     */
    private ChannelProfile mapChannelProfileResponse(String jsonResponse) {
        JSONObject jsonObject = new JSONObject(jsonResponse);
        JSONArray items = jsonObject.getJSONArray("items");

        if (items.length() == 0) {
            throw new RuntimeException("Channel not found");
        }

        JSONObject channel = items.getJSONObject(0);
        JSONObject snippet = channel.optJSONObject("snippet");
        JSONObject statistics = channel.optJSONObject("statistics");

        if (snippet == null || statistics == null) {
            throw new RuntimeException("Malformed response, missing snippet or statistics data");
        }

        ChannelProfile profile = new ChannelProfile();
        profile.setTitle(snippet.optString("title", "Unknown Title"));
        profile.setDescription(snippet.optString("description", "No description available"));
        profile.setThumbnailUrl(snippet.getJSONObject("thumbnails").optJSONObject("default").optString("url", "default_thumbnail_url"));
        profile.setViewCount(Integer.parseInt(statistics.optString("viewCount", "0")));
        profile.setSubscriberCount(Integer.parseInt(statistics.optString("subscriberCount", "0")));
        profile.setVideoCount(statistics.optString("videoCount", "0"));

        return profile;
    }

    public static class ChannelProfileRequest {
        private final String channelId;

        public ChannelProfileRequest(String channelId) {
            this.channelId = channelId;
        }

        public String getChannelId() {
            return channelId;
        }

        public String ChannelId() {
            return channelId;
        }
    }


}
