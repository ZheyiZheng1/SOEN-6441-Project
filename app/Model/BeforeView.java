package Model;
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
import java.io.IOException;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;

import static play.mvc.Results.ok;

public class BeforeView {
    // This ConcurrentHashMap will store search results regarding session
    // basically, each session has corrsponding arraylist (hold up to 10 search history), each arraylist has another arraylist of string to store result.
    private final ConcurrentHashMap<String, ArrayList<ArrayList<ArrayList<TextSegment>>>> userSearchResults;
    private final ConcurrentHashMap<String, ArrayList<String>> userKeywords;
    private final ConcurrentHashMap<String, ArrayList<ArrayList<String>>> userReadabilitys;
    public BeforeView(){
        super();
        userSearchResults = new ConcurrentHashMap<>();
        userKeywords = new ConcurrentHashMap<>();
        userReadabilitys = new ConcurrentHashMap<>();
    }

    public CompletableFuture<Result> process(Request request, String sessionId, String keyword, CompletableFuture<List<YTResponse>> result, FormFactory formFactory, MessagesApi messagesApi) throws ExecutionException, InterruptedException {

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
                TextSegment thumbnail = new TextSegment("thumbnail", ytResponse.getThumbnailUrl());

                // Form the search result.
                temp.add(title1);
                temp.add(title2);
                temp.add(channel1);
                temp.add(channel2);
                temp.add(description);
                temp.add(fkgl);
                temp.add(fre);
                temp.add(tag);
                temp.add(thumbnail);
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
}
