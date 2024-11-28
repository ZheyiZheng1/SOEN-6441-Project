package actors;

import akka.actor.AbstractActor;
import akka.actor.Props;
import actors.ProjectProtocol.WordStatsRequest;
import actors.ProjectProtocol.WordStatsResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import services.WordStatService;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public class WordStatsActor extends AbstractActor {

    public static Map<String, JsonNode> wordStatsMap = new HashMap<>();

    public static Props getProps() {
        return Props.create(WordStatsActor.class);
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(WordStatsRequest.class, message -> {
                    Map<String, Long> wordStats = new WordStatService().getWordFrequency(message.getDescriptions());
                    System.out.println("size "+wordStats.entrySet().size());
                    Map<String, Long> sortWordByFrequency = new WordStatService().sortWordsByFrequency(wordStats);
                    System.out.println("size sort "+ sortWordByFrequency.entrySet().size());
                    getSender().tell(new WordStatsResults(message.videoId, sortWordByFrequency), getSelf());
                })
                .build();
    }

    public static class WordStatsResults {
        public final String videoId;
        public final JsonNode wordStats;

        public WordStatsResults(String videoId, Map<String, Long> wordStats) {
            this.videoId = videoId;
            ObjectMapper mapper = new ObjectMapper();
            this.wordStats = mapper.valueToTree(wordStats);
            System.out.println(wordStats);
        }
    }
}
