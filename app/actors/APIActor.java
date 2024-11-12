package actors;

import akka.actor.*;
import akka.japi.*;
import actors.ProjectProtocol.*;
import services.YTResponse;
import services.YTRestDir;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author: Zheyi Zheng - 40266266
 * Created: 2024/11/11
 * This is the APIAcotr class. This class is responsible to make API call to YouTube.
 */
public class APIActor extends AbstractActor{
    // Create YTRestDir
    private static YTRestDir ytRestDir;

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/11/11
     * This is the getProps method. This method allows Props create APIActor.
     * @return Props Proper return object in Akka
     */
    public static Props getProps() {
        return Props.create(APIActor.class);
    }

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/11/11
     * This is the constructor method. This method create a static YTRestDir object when the APIActor gets created.
     */
    public APIActor(){ytRestDir = new YTRestDir();}

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/11/11
     * This is the createReceive method. This method distinguish messages.
     * If the message is KeyWordSearch class, then return a search result to requester. Else, do nothing.
     * @return Receive proper return object in Akka
     */
    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(KeyWordSearch.class, message -> {
                    // Retrieve keyword
                    String keyword = message.keyword;

                    // Retrieve search result
                    CompletableFuture<List<YTResponse>> result = ytRestDir.searchVideosAsynch(keyword, null, null);
                    // Send a message back to requester
                    sender().tell(result, self());
                })
                .build();
    }
}
