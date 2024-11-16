package controllers;

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

public class NewHomeController extends Controller {

    private final ActorSystem actorSystem;
    private final Materializer materializer;

    @Inject
    public NewHomeController(ActorSystem actorSystem, Materializer materializer) {
        this.actorSystem = actorSystem;
        this.materializer = materializer;
    }

    public Result index(){
        // The view with only a search box
        return ok(views.html.index.render());
    }

    // WebSocket method
    public WebSocket ws() {
        // Create a web socket and return
        return WebSocket.Text.acceptOrResult(request -> {
            // Create the APIActor
            ActorRef apiActor = actorSystem.actorOf(APIActor.getProps());
            return CompletableFuture.completedFuture(Either.Right(
                    ActorFlow.actorRef(out -> WebSocketActor.props(out, apiActor), actorSystem, materializer)
            ));
        });
    }
}
