/**
 * @author: Zheyi Zheng - 40266266
 * Created: 2024/10/24
 * This is the home controller.
 */
package controllers;

import Model.SearchForm;
import play.data.Form;
import play.mvc.*;

import views.html.Home.display;
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

    public Result search(){
        return ok();
    }
}
