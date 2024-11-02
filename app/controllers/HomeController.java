/**
 * @author: Zheyi Zheng - 40266266
 * Created: 2024/10/24
 * This is the home controller.
 */
package controllers;

import Model.SearchForm;
import play.data.Form;
import play.mvc.*;

import services.ReadabilityService;
import services.YTResponse;
import services.YTRestDir;
import views.html.Home.display;
import play.data.FormFactory;

import javax.inject.Inject;
import java.util.List;
import java.util.concurrent.CompletableFuture;


public class HomeController extends Controller {

    private final AssetsFinder assetsFinder;
    private final FormFactory formFactory;

    @Inject
    public HomeController(AssetsFinder assetsFinder, FormFactory formFactory) {
        this.assetsFinder = assetsFinder;
        this.formFactory = formFactory;
    }

    public Result index(){
        return ok("Hello world");
    }

    /**
     * Basic home page of this application. url:"/"
     * Author: Zheyi Zheng - 40266266
     * Created: 2024/10/24
     */
    public Result display() {
        // Create form based on SearchForm and FormFactory.
        Form<SearchForm> searchForm = formFactory.form(SearchForm.class);
        // Pass the form to display view.
        return ok(display.render(searchForm));
    }

    /**
     * Basic search page of this application. Use it to display search result. Still need to display search bar
     * Author: Zheyi Zheng - 40266266
     * Created: 2024/10/24
     */
    public Result search(){
        // Receive submitted keyword
        // TODO
        // Create YTRestDir
        YTRestDir ytRestDir = new YTRestDir();
        // Get search result. (Replace the following keyword to actual keyword String)
        CompletableFuture<List<YTResponse>> result =  ytRestDir.searchVideosAsynch(keyword, null, 10);
        // Create ReadabilityService and get calculation result.
        ReadabilityService rs = new ReadabilityService(result);
        List<Double> listOfFRE = rs.getFre();
        List<Double> listOfFKGL = rs.getFkgl();
        Double avgFRE = rs.getAvgFRE();
        Double avgFKGL = rs.getAvgFKGL();
        // Form search result and information from personal part into one. Store it somewhere(Keep at most 10 search results).
        // TODO
        // Create form just like display().
        // TODO
        // Pass all information to the view (Including previous search history).
        // TODO
        return ok();
    }
}
