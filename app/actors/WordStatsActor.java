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

/**
 * @author: Praneet Avhad - 40279347
 * The {@code WordStatsActor} is an Akka actor responsible for processing word statistics
 * requests. It receives {@link WordStatsRequest} messages, computes word frequencies,
 * sorts the words by frequency, and sends back the results as {@link WordStatsResults}.

 */
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

    /**
     * @author: Praneet Avhad - 40279347
     * The {@code WordStatsResults} class encapsulates the results of a word statistics
     * computation. It includes the video ID and a JSON representation of word frequencies.
     * This message is sent back to the sender after processing a {@link WordStatsRequest}.
     */
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
