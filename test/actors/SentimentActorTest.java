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
    public void  TestSentiment_Happy() {
        ActorSystem Testsystem;
        Testsystem = ActorSystem.create();
        new TestKit(Testsystem){{
            //Initialize the Input
            YTResponse mock1 = new YTResponse();
            String Description1 = "happy joyful disappointed blissful cheerful defeated satisfied relaxed fulfilled surprised peaceful eager.";
            mock1.setDescription(Description1);
            List<YTResponse> mockList = new ArrayList<>();
            mockList.add(mock1);
            CompletableFuture<List<YTResponse>> Input = CompletableFuture.completedFuture(mockList);
            //Create a TestActor
            TestActorRef<SentimentActor> TestStmActor = TestActorRef.create(Testsystem,SentimentActor.props());
            ProjectProtocol.SentimentCheck stm = new ProjectProtocol.SentimentCheck(Input);
            //Send the SentimentCheck message to Test
            TestStmActor.tell(stm,getTestActor());
            ProjectProtocol.SentimentResponse response = expectMsgClass(ProjectProtocol.SentimentResponse.class);
            //test the final result
            assertEquals(":-)",response.sentiment);
        }};
    }

    /**
     * @author: Jiaxi Liu - 40278106
     * Created: 2024/11/27
     * The method is used to test the situation of sad sentiment
     */
    @Test
    public void  TestSentiment_Sad() {
        ActorSystem Testsystem;
        Testsystem = ActorSystem.create();
        new TestKit(Testsystem){{
            //Initialize the Input
            YTResponse mock2 = new YTResponse();
            String Description2 = " weary stifled unfulfilled neglected discouraged frustrated meaningless ignored down";
            mock2.setDescription(Description2);
            List<YTResponse> mockList = new ArrayList<>();
            mockList.add(mock2);
            CompletableFuture<List<YTResponse>> Input = CompletableFuture.completedFuture(mockList);
            //Create a TestActor
            TestActorRef<SentimentActor> TestStmActor = TestActorRef.create(Testsystem,SentimentActor.props());
            ProjectProtocol.SentimentCheck stm = new ProjectProtocol.SentimentCheck(Input);
            //Send the SentimentCheck message to Test
            TestStmActor.tell(stm,getTestActor());
            ProjectProtocol.SentimentResponse response = expectMsgClass(ProjectProtocol.SentimentResponse.class);
            //test the final result
            assertEquals(":-(",response.sentiment);
        }};
    }

    /**
     * @author: Jiaxi Liu - 40278106
     * Created: 2024/11/27
     * The method is used to test the situation of normal sentiment
     */
    @Test
    public void  TestSentiment_Normal() {
        ActorSystem Testsystem;
        Testsystem = ActorSystem.create();
        new TestKit(Testsystem){{
            //Initialize the Input
            YTResponse mock3 = new YTResponse();
            String Description3 = "This is a java program ";
            mock3.setDescription(Description3);
            List<YTResponse> mockList = new ArrayList<>();
            mockList.add(mock3);
            CompletableFuture<List<YTResponse>> Input = CompletableFuture.completedFuture(mockList);
            //Create a TestActor
            TestActorRef<SentimentActor> TestStmActor = TestActorRef.create(Testsystem,SentimentActor.props());
            ProjectProtocol.SentimentCheck stm = new ProjectProtocol.SentimentCheck(Input);
            //Send the SentimentCheck message to Test
            TestStmActor.tell(stm,getTestActor());
            ProjectProtocol.SentimentResponse response = expectMsgClass(ProjectProtocol.SentimentResponse.class);
            //test the final result
            assertEquals(":-|",response.sentiment);
        }};
    }

}