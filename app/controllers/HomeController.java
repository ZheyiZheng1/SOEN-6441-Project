/**
 * @author: Zheyi Zheng - 40266266
 * Created: 2024/10/24
 * This is the home controller.
 */
package controllers;

import play.data.DynamicForm;
import play.mvc.*;
import views.html.Home.display;
import views.html.Home.searchResults;
import play.data.FormFactory;
import javax.inject.Inject;

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
     * Basic home page of this application. url:"/ytlytics"
     * Author: Zheyi Zheng - 40266266
     * Created: 2024/10/24
     */
    public Result display(){
        return ok(display.render());
    }

    /**
     * Basic home page of this application. url:"/search"
     * Author: Zheyi Zheng - 40266266
     * Created: 2024/10/25
     */
    public Result search() {
        // Create a DynamicForm to bind the form data
        DynamicForm form = formFactory.form();
        // Extract the search term from the form
        //String searchQuery = form.bindFromRequest().get("search");

        // Process the search query as needed, for now, let's just render it
        //return ok(searchResults.render(searchQuery));
        return ok();
    }

}
