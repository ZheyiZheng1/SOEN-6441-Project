package actors;


import akka.actor.*;
import akka.testkit.TestActorRef;
import akka.testkit.javadsl.TestKit;
import services.YTResponse;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SentimentActorTest {

    /**
     * @author: Jiaxi Liu - 40278106
     * Created: 2024/11/27
     * The method is used to test the situation of happy sentiment
     */
    @Test
    public void  TestSentiment() {
        ActorSystem Testsystem;
        Testsystem = ActorSystem.create();
        new TestKit(Testsystem) {{
            //Initialize the Input
            YTResponse mock1 = new YTResponse();
            YTResponse mock2 = new YTResponse();
            YTResponse mock3 = new YTResponse();
            String Description1 = "joyful disappointed blissful cheerful disappointed blissful cheerful relaxed fulfilled  OK normal";
            String Description2 = " weary stifled unfulfilled neglected discouraged frustrated meaningless ignored down";
            String Description3 = "Scarlett O'Hara was not beautiful, but men seldom realized it when caught by her charm as the Tarleton twins were.In her face were too sharply blended the delicate features of her mother, a Coast aristocrat of French descent, and the heavy ones of her florid Irish father.";
            mock1.setDescription(Description1);
            mock2.setDescription(Description2);
            mock3.setDescription(Description3);
            List<YTResponse> mockList = new ArrayList<>();
            mockList.add(mock1);
            mockList.add(mock2);
            mockList.add(mock3);
            CompletableFuture<List<YTResponse>> Input = CompletableFuture.completedFuture(mockList);
            //Create a TestActor
            TestActorRef<SentimentActor> TestStmActor = TestActorRef.create(Testsystem, SentimentActor.props());
            ProjectProtocol.SentimentCheck stm = new ProjectProtocol.SentimentCheck(Input);
            //Send the SentimentCheck message to Test
            TestStmActor.tell(stm, getTestActor());
            ProjectProtocol.SentimentResponse response = expectMsgClass(ProjectProtocol.SentimentResponse.class);
            //test the final result
            assertEquals(":-|", response.sentiment);
        }};
    }


}