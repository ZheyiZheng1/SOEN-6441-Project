package controllers;

import actors.ReadabilityActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.stream.Materializer;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.WebSocket;
import javax.inject.Inject;
import akka.actor.Props;
import play.libs.F.Either;
import play.libs.streams.ActorFlow;
import java.util.concurrent.CompletableFuture;
import actors.APIActor;
import actors.WebSocketActor;

/**
 * @author: Zheyi Zheng - 40266266
 * Created: 2024/11/14
 * This is the NewHomeController class. This is the only controller we use in project 2.
 */
public class NewHomeController extends Controller {

    private final ActorSystem actorSystem;
    private final Materializer materializer;

    @Inject
    public NewHomeController(ActorSystem actorSystem, Materializer materializer) {
        this.actorSystem = actorSystem;
        this.materializer = materializer;
    }

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/11/14
     * This is the index method. This method make sure user can reach the index page with on data correctly.
     * @return  Result standard return value in Play framework.
     */
    public Result index(){
        // The view with only a search box
        return ok(views.html.index.render());
    }

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/11/14
     * This is the ws method. This method make sure program act correctly when user side request to open a websocket.
     * When user request to open a websocket with a search keyword, create an WebSocketActor to communicate with user.
     * APIActor in charge of making API call to YouTube.
     * @return WebSocket standard return for websocket.
     */
    public WebSocket ws() {
        // Create a web socket and return
        return WebSocket.Text.acceptOrResult(request -> {
            // Create the APIActor
            ActorRef apiActor = actorSystem.actorOf(APIActor.getProps());
            ActorRef readabilityActor = actorSystem.actorOf(ReadabilityActor.getProps());
            return CompletableFuture.completedFuture(Either.Right(
                    ActorFlow.actorRef(out -> WebSocketActor.props(out, apiActor, readabilityActor), actorSystem, materializer)
            ));
        });
    }
}
