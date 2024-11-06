/**
 * @author: Zheyi Zheng - 40266266
 * Created: 2024/10/24
 * This is the home controller.
 */
package controllers;

import Model.SearchForm;
import Model.TextSegment;
import play.data.Form;
import play.mvc.*;
import play.i18n.MessagesApi;
import play.i18n.Messages;
import play.mvc.Http.Request;

import services.ReadabilityService;
import services.WordStatService;
import services.YTResponse;
import services.YTRestDir;
import views.html.Home.display;
import views.html.Home.searchResults;
import play.data.FormFactory;
import views.html.Home.videoStatistics;

import javax.inject.Inject;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutionException;


public class HomeController extends Controller {
    // This ConcurrentHashMap will store search results regarding session
    // basically, each session has corrsponding arraylist (hold up to 10 search history), each arraylist has another arraylist of string to store result.
    private final ConcurrentHashMap<String, ArrayList<ArrayList<ArrayList<TextSegment>>>> userSearchResults = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, ArrayList<String>> userKeywords = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, ArrayList<ArrayList<String>>> userReadabilitys = new ConcurrentHashMap<>();

    private final FormFactory formFactory;
    private final MessagesApi messagesApi;

    @Inject
    public HomeController(AssetsFinder assetsFinder, FormFactory formFactory, MessagesApi messagesApi) {
        this.formFactory = formFactory;
        this.messagesApi = messagesApi;
    }

    public Result index(){
        return ok("Hello world");
    }

    /**
     * Basic home page of this application. url:"/"
     * Author: Zheyi Zheng - 40266266
     * Created: 2024/10/24
     */
    public Result display(Request request) {
        // Create form based on SearchForm and FormFactory.
        Form<SearchForm> searchForm = formFactory.form(SearchForm.class);
        Messages messages = messagesApi.preferred(request);
        // Pass the form to display view.
        return ok(display.render(searchForm, messages));
    }

    /**
     * Basic search page of this application. Use it to display search result. Still need to display search bar
     * Author: Zheyi Zheng - 40266266
     * Created: 2024/10/24
     */
    public CompletableFuture<Result> search(Request request) throws ExecutionException, InterruptedException {
        Form<SearchForm> searchForm = formFactory.form(SearchForm.class).bindFromRequest(request);
        // In case of bad request, just return empty arraylist to the view.
        if (searchForm.hasErrors()) {
            //return badRequest(searchResults.render(new ArrayList<>(), new ArrayList<>(), searchForm, messagesApi.preferred(request), request));
        }
        // Get keyword
        String keyword = searchForm.get().getKeyword();
        // Get session id
        String sessionId = getSessionId(request);
        YTRestDir ytRestDir = new YTRestDir();
        // Get search result
        CompletableFuture<List<YTResponse>> result = ytRestDir.searchVideosAsynch(keyword, null, "10");

        ArrayList<ArrayList<TextSegment>> currentResult = new ArrayList<>();
        return result.thenApply(list -> {
            // Get readability data
            ReadabilityService rs = new ReadabilityService(result);
            List<Double> listOfFRE = rs.getFre();
            List<Double> listOfFKGL = rs.getFkgl();

            int index = 0;
            for (YTResponse ytResponse : list) {
                ArrayList<TextSegment> temp = new ArrayList<>();
                TextSegment title1 = new TextSegment("Title: ", null);
                TextSegment title2 = new TextSegment(ytResponse.getTitle(), ytResponse.getVideoLink());
                TextSegment channel1 = new TextSegment(", Channel: ", null);
                TextSegment channel2 = new TextSegment(ytResponse.getChannelTitle(), ytResponse.getChannelProfileLink());
                TextSegment description = new TextSegment(", Description: " + ytResponse.getDescription(), null);

                // Check if readability data is ready, if not use N/A instead.
                String fkglValue = (listOfFKGL.size() > index) ? listOfFKGL.get(index).toString() : "N/A";
                String freValue = (listOfFRE.size() > index) ? listOfFRE.get(index).toString() : "N/A";

                TextSegment fkgl = new TextSegment(". Flesh-Kincaid Grade Level=" + fkglValue, null);
                TextSegment fre = new TextSegment(", Flesch Reading Ease Score=" + freValue, null);
                TextSegment tag = new TextSegment("Tags", null);
                // Form the search result.
                temp.add(title1);
                temp.add(title2);
                temp.add(channel1);
                temp.add(channel2);
                temp.add(description);
                temp.add(fkgl);
                temp.add(fre);
                temp.add(tag);
                currentResult.add(temp);
                index++;
            }
            // Create/find the current user's ArrayList
            ArrayList<ArrayList<ArrayList<TextSegment>>> userList = userSearchResults.computeIfAbsent(sessionId, k -> new ArrayList<>());
            ArrayList<String> userKeyword = userKeywords.computeIfAbsent(sessionId, k -> new ArrayList<>());
            ArrayList<ArrayList<String>> userReadability = userReadabilitys.computeIfAbsent(sessionId, k -> new ArrayList<>());
            // Add the result to the top of the list.
            userList.add(0, currentResult);
            userKeyword.add(0, keyword);
            userReadability.add(0, new ArrayList<>(Arrays.asList(rs.getAvgFKGL().toString(), rs.getAvgFRE().toString())));
            // Trim the list to make sure we only keep 10 most recent results
            if (userList.size() > 10) {
                userList.remove(userList.size() - 1);
            }
            if (userKeyword.size() > 10) {
                userKeyword.remove(userKeyword.size() - 1);
            }
            if (userReadability.size() > 10) {
                userReadability.remove(userReadability.size() - 1);
            }
            // Create the search box
            Form<SearchForm> searchForm2 = formFactory.form(SearchForm.class);
            Messages messages = messagesApi.preferred(request);
            // pass everything to the view.
            return ok(searchResults.render(userKeyword, userList, userReadability, searchForm2, messages, request))
                    .withSession(request.session().adding("sessionId", sessionId));
        });

    }

    /**
     * Simple getSessionId method. This method will get session id from user request. If no id exist, it will create it.
     * Author: Zheyi Zheng - 40266266
     * Created: 2024/10/24
     */
    private String getSessionId(Request request){
        // Try to get session id from user request
        Optional<String> sessionId = request.session().get("sessionId");
        // If there is a session id, return it. If not, create is randomly.
        return sessionId.orElseGet(() -> UUID.randomUUID().toString());
    }

    public Result videoStatistics(String keyword) throws ExecutionException, InterruptedException, IOException {
        CompletableFuture<List<YTResponse>> videosFuture = new YTRestDir().searchVideosAsynch(keyword,null, "50");
        //CompletableFuture<List<YTResponse>> videosFuture = getLatestVideos(keyword);
        List<YTResponse> videos = videosFuture.get();
        System.out.println(videos.get(0));
        Map<String, Long> wordFrequency = new WordStatService().getWordFrequency(videos);
        Map<String, Long> sortedWordFrequency = new WordStatService().sortWordsByFrequency(wordFrequency);
//        Map<String, Long> sortedWordFrequency = new LinkedHashMap<>();
//        sortedWordFrequency.put("test1", 45L);
//        sortedWordFrequency.put("test2", 45L);
//        sortedWordFrequency.put("test3", 45L);
//        sortedWordFrequency.put("test4", 45L);

        return ok(videoStatistics.render(sortedWordFrequency));
    }
}
