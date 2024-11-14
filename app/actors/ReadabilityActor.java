package actors;

import akka.actor.*;
import akka.japi.*;
import actors.ProjectProtocol.*;
import services.ReadabilityService;
import services.YTResponse;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import akka.actor.AbstractActor;

/**
 * @author: Zheyi Zheng - 40266266
 * Created: 2024/11/12
 * This is the ReadabilityActor class. This class is responsible to take a search result and send back a ReadabilityService.
 */
public class ReadabilityActor extends AbstractActor {
    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/11/11
     * This is the getProps method. This method allows Props create APIActor.
     * @return Props Proper return object in Akka
     */
    public static Props getProps() {
        return Props.create(ReadabilityActor.class);
    }

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/11/11
     * This is the createReceive method. This method read search result from message and send ReadabilityService to requester.
     * @return Receive proper return object in Akka
     */
    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(ReadabilityCheck.class, message -> {
                    // Retrieve search result from message
                    CompletableFuture<List<YTResponse>> result = message.result;
                    // Create the ReadabilityService instance
                    ReadabilityService rs = new ReadabilityService(result);
                    sender().tell(rs, self());
                })
                .build();
    }
}
