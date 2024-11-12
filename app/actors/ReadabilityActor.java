package actors;

import akka.actor.*;
import akka.japi.*;
import actors.ProjectProtocol.*;
import services.YTResponse;
import services.YTRestDir;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import akka.actor.AbstractActor;

public class ReadabilityActor extends AbstractActor {
    public static Props getProps() {
        return Props.create(APIActor.class);
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(KeyWordSearch.class, message -> {
                    // Retrieve keyword
                    String keyword = message.keyword;
                    // Perform search by create YTRestDir
                    YTRestDir ytRestDir = new YTRestDir();
                    // Retrieve search result
                    CompletableFuture<List<YTResponse>> result = ytRestDir.searchVideosAsynch(keyword, null, null);
                    // Send a message back to requester
                    sender().tell(result, self());
                })
                .build();
    }
}
