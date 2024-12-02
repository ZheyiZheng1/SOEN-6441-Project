package actors;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import akka.actor.ActorSystem;
import akka.actor.ActorRef;
import akka.testkit.TestActorRef;
import akka.testkit.javadsl.TestKit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import services.YTResponse;
import Model.ChannelProfile;
import actors.APIActor.ChannelProfileRequest;

public class ChannelProfileActorTest {

    private ActorSystem system;
    private ActorRef mockWebSocketActor;
    private ActorRef mockApiActor;

    /**
     * @author: Sakshi Mulik-40295793
     * Setup method that initializes the ActorSystem and mocks for WebSocket and API actors.
     */
    @Before
    public void setUp() {
        system = ActorSystem.create(); // Create a new ActorSystem for testing
        mockWebSocketActor = mock(ActorRef.class); // Mock WebSocket Actor to simulate communication
        mockApiActor = mock(ActorRef.class); // Mock API Actor to simulate interaction with the API
    }

    /**
     * @author: Sakshi Mulik-40295793
     * Created: 2024/12/01
     * Teardown method that shuts down the ActorSystem after each test.
     */
    @After
    public void tearDown() {
        TestKit.shutdownActorSystem(system);
    }

    /**
     * @author: Sakshi Mulik-40295793
     * Created: 2024/12/01
     * Test case to verify that the ChannelProfileActor correctly handles a ChannelProfileRequest.
     * It checks if the correct ChannelProfile is sent to the WebSocket actor.
     */
    @Test
    public void testChannelProfileActor() {
        new TestKit(system) {{
            //  mock ChannelProfile to return as the expected result
            ChannelProfile mockProfile = new ChannelProfile("mockChannelId", "Mock Channel Title", "1000 Subscribers");

            //  TestActorRef for the ChannelProfileActor, passing mock WebSocket and API actors
            TestActorRef<ChannelProfileActor> actorRef = TestActorRef.create(
                    system, ChannelProfileActor.props("mockChannelId", mockWebSocketActor, mockApiActor)
            );

            // Sending a ChannelProfileRequest to the actor
            actorRef.tell(new ChannelProfileRequest("mockChannelId"), getTestActor());

            // Expect a ChannelProfile response from the WebSocketActor
            expectMsgClass(ChannelProfile.class); // Expect that the test actor receives a ChannelProfile response

            // Verifying that the WebSocket actor was told the correct profile
            //  ArgumentCaptor to capture the argument passed to the WebSocket actor
            ArgumentCaptor<ChannelProfile> captor = ArgumentCaptor.forClass(ChannelProfile.class);
            verify(mockWebSocketActor, times(1)).tell(captor.capture(), eq(getTestActor())); // Ensure correct recipient

            //  captured ChannelProfile and assert that its properties are correct
            ChannelProfile capturedProfile = captor.getValue();
            assertEquals("mockChannelId", capturedProfile.getChannelId()); // Verify channel ID
            assertEquals("Mock Channel Title", capturedProfile.getTitle()); // Verify channel title
            assertEquals("1000 Subscribers", capturedProfile.getSubscriberCount()); // Verify subscriber count
        }};
    }

    /**
     * @author: Sakshi Mulik-40295793
     * Created: 2024/12/01
     * Test case to verify the behavior when the API actor is mocked and doesn't perform any action.
     * This test simulates the API actor not returning any data and ensures the WebSocket actor is notified correctly.
     */
    @Test
    public void testChannelProfileActorWithMockedApi() {
        new TestKit(system) {{
            // Prepareing a mock profile returned from the mock API actor
            ChannelProfile mockProfile = new ChannelProfile("mockChannelId", "Mock Channel Title", "1000 Subscribers");

            //TestActorRef for both WebSocket and API actors
            TestActorRef<ChannelProfileActor> actorRef = TestActorRef.create(
                    system, ChannelProfileActor.props("mockChannelId", mockWebSocketActor, mockApiActor)
            );

            // Simulating  the API actor returning a response by mocking the tell method for void return type
            doNothing().when(mockApiActor).tell(any(), any());

            // Send a ChannelProfileRequest to the actor
            actorRef.tell(new ChannelProfileRequest("mockChannelId"), getTestActor());

            // Expect that the response is correctly passed to the WebSocket actor
            ArgumentCaptor<ChannelProfile> captor = ArgumentCaptor.forClass(ChannelProfile.class);
            verify(mockWebSocketActor, times(1)).tell(captor.capture(), eq(getTestActor()));

            // Assert that the captured profile values match the expected values
            ChannelProfile capturedProfile = captor.getValue();
            assertEquals("mockChannelId", capturedProfile.getChannelId()); // Verifying channel ID
            assertEquals("Mock Channel Title", capturedProfile.getTitle()); // Verifying channel title
            assertEquals("1000 Subscribers", capturedProfile.getSubscriberCount()); // Verifying subscriber count
        }};
    }
}
