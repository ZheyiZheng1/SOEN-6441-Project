package actors;

import akka.actor.*;
import akka.japi.*;
import actors.ProjectProtocol.*;
/**
 * @author: Zheyi Zheng - 40266266
 * Created: 2024/11/11
 * This is the APIAcotr class. This class is responsible to make API call to YouTube.
 */
public class APIActor extends AbstractActor{
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

                })
                .build();
    }
}
