/**
 * @author: Zheyi Zheng - 40266266
 * Created: 2024/10/24
 * This is the home controller. It is the only controller for this project.
 */
package controllers;

import Model.BeforeView;
import Model.SearchForm;
import play.data.Form;
import play.mvc.*;
import play.i18n.MessagesApi;
import play.i18n.Messages;
import play.mvc.Http.Request;

import services.WordStatService;
import services.YTResponse;
import services.YTRestDir;
import views.html.Home.display;
import play.data.FormFactory;
import views.html.Home.videoStatistics;

import javax.inject.Inject;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;


public class HomeController extends Controller {

    private final FormFactory formFactory;
    private final MessagesApi messagesApi;
    private final BeforeView beforeView;
    private CompletableFuture<List<YTResponse>> result_demo = new CompletableFuture<List<YTResponse>>();
    /**
     * Constructor method. This method creates a BeforeView model and inject the dependency of FormFactory and MessageApi.
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/10/24
     * @param formFactory just the form factory, use to future form generate. messageApi is also required for form generate.
     */
    @Inject
    public HomeController(FormFactory formFactory, MessagesApi messagesApi) {
        this.formFactory = formFactory;
        this.messagesApi = messagesApi;
        this.beforeView = new BeforeView();
    }

    /**
     * Basic home page of this application. url:"/"
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/10/24
     * @param request take Request from user
     * @return The Result.
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
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/10/24
     * @param request take Request from user
     * @throws ExecutionException if some of the results from helper class is not ready
     * @throws InterruptedException if some of the threads got interrupt during processing.
     * @return The CompletableFuture of Result.
     */
    public CompletableFuture<Result> search(Request request) throws ExecutionException, InterruptedException {
        Form<SearchForm> searchForm = formFactory.form(SearchForm.class).bindFromRequest(request);

        // Get keyword
        String keyword = searchForm.get().getKeyword();
        YTRestDir ytRestDir = new YTRestDir();
        // Get search result
        CompletableFuture<List<YTResponse>> result = ytRestDir.searchVideosAsynch(keyword, null, "50");
        result_demo = result;
        CompletableFuture<List<YTResponse>> result2 = result
                .thenApply(list -> list.stream().limit(10).collect(Collectors.toList()));
        // Call BeforeView to get and return the information to view.
        return beforeView.process(request, keyword, result2, formFactory, messagesApi);

    }

    /**
     * Simple getSessionId method. This method will get session id from user request. If no id exist, it will create it.
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/10/24
     * @return The request
     */
    private String getSessionId(Request request){
        // Try to get session id from user request
        Optional<String> sessionId = request.session().get("sessionId");
        // If there is a session id, return it. If not, create is randomly.
        return sessionId.orElseGet(() -> UUID.randomUUID().toString());
    }

     /**
     * Calling the word stat service .
     * @author: Praneet Avhad - 40279347
     */
    public Result videoStatistics(String keyword) throws ExecutionException, InterruptedException, IOException {
        //CompletableFuture<List<YTResponse>> videosFuture = new YTRestDir().searchVideosAsynch(keyword,null, "50");
        //CompletableFuture<List<YTResponse>> videosFuture = getLatestVideos(keyword);
        List<YTResponse> videos = result_demo.get();
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
