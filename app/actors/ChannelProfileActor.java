package actors;

import Model.ChannelProfile;
import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import services.YTResponse;
import play.Logger;

/**
 * @author: Sakshi Mulik - 40295793
 * Created: 2024/11/27
 * This actor handles requests to fetch channel profiles and sends the profile data to a WebSocketActor.
 */
public class ChannelProfileActor extends AbstractActor {
    private final String channelId;
    private final ActorRef webSocketActor; // WebSocketActor reference to send the response to
    private final ActorRef apiActor; // Reference to the API Actor

    private static final Logger.ALogger log = Logger.of(ChannelProfileActor.class);

    /**
     * Constructor to initialize the actor with required dependencies.
     * @param channelId The ID of the channel for which profile is to be fetched.
     * @param webSocketActor The actor responsible for handling WebSocket communication.
     * @param apiActor The actor responsible for API interactions to fetch channel data.
     */
    public ChannelProfileActor(String channelId, ActorRef webSocketActor, ActorRef apiActor) {
        this.channelId = channelId;
        this.webSocketActor = webSocketActor;
        this.apiActor = apiActor;
    }

    /**
     * Factory method to create a new instance of ChannelProfileActor with required dependencies.
     * @param channelId The ID of the channel for which profile is to be fetched.
     * @param webSocketActor The actor responsible for handling WebSocket communication.
     * @param apiActor The actor responsible for API interactions to fetch channel data.
     * @return A Props object to create the actor with its dependencies.
     */
    public static Props props(String channelId, ActorRef webSocketActor, ActorRef apiActor) {
        return Props.create(ChannelProfileActor.class, () -> new ChannelProfileActor(channelId, webSocketActor, apiActor));
    }

    /**
     * Method to define the behavior of the actor. It listens for ChannelProfileRequest messages.
     * @return The behavior of the actor based on incoming messages.
     */
    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(APIActor.ChannelProfileRequest.class, this::onChannelProfileRequest)
                .build();
    }

    /**
     * Method to handle the ChannelProfileRequest message, fetch the channel profile, and send it to the WebSocketActor.
     * @param request The request message containing the channel ID.
     */
    private void onChannelProfileRequest(APIActor.ChannelProfileRequest request) {
        // Here, you would call a service or API to fetch the actual profile
        ChannelProfile profile = fetchChannelProfile(request.ChannelId());
        // Send the profile back to the WebSocket actor (or whoever the response should go to)
        webSocketActor.tell(profile, getSelf());
    }

    /**
     * Method to fetch the channel profile (mocked for now, replace with actual logic).
     * @param channelId The ID of the channel to fetch the profile for.
     * @return A mock ChannelProfile object with sample data.
     */
    private ChannelProfile fetchChannelProfile(String channelId) {
        // This can be replaced with actual logic to fetch data
        return new ChannelProfile(channelId, "Mock Channel Title", "1000 Subscribers");
    }

    /**
     * Getter method for the channel ID.
     * @return The channel ID.
     */
    public String getChannelId() {
        return channelId;
    }
}
