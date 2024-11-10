import Model.BeforeView;
import org.junit.Test;
import play.Application;
import play.data.FormFactory;
import play.i18n.MessagesApi;
import play.inject.guice.GuiceApplicationBuilder;
import play.mvc.Http;
import play.mvc.Result;
import services.YTResponse;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static play.test.Helpers.*;


/**
 * @author: Zheyi Zheng - 40266266
 * @author: Jiaxi Liu - 40278106
 * Created: 2024/11/9
 * This is the BeforeViewTest class. This class test the process method in BeforeView.
 */
public class BeforeViewTest {



 /**
  * @author: Zheyi Zheng - 40266266
  * @author: Jiaxi Liu - 40278106
  * Created: 2024/11/9
  * Test the process function in BeforeView.
  * Provide sample input to Before view process method and retrieve the Result.
  * Turn Result into html in String and then check if all the sample information appears correctly.
  */
   @Test
   public void processTest() throws ExecutionException, InterruptedException {
    BeforeView beforeView = new BeforeView();
    String Keyword = "Java";
    CompletableFuture<List<YTResponse>> result;
    Http.RequestBuilder requestbuilder= fakeRequest(GET, "/");
    Http.Request request = requestbuilder.build();
    Application app = new GuiceApplicationBuilder().build();
    FormFactory formFactory = app.injector().instanceOf(FormFactory.class);
    MessagesApi messagesApi = app.injector().instanceOf(MessagesApi.class);

    YTResponse ytResponse = new YTResponse();
    ytResponse.setTitle("Sample Video");
    ytResponse.setVideoId("12345");
    ytResponse.setVideoLink("https://www.youtube.com/watch?v=12345");
    ytResponse.setChannelTitle("Sample Channel");
    ytResponse.setChannelId("abcde");
    ytResponse.setChannelProfileLink("https://www.youtube.com/channel/abcde");
    ytResponse.setDescription("This is the sample description.");
    ytResponse.setThumbnailUrl("https://i.ytimg.com/vi/12345/default.jpg");
    List<YTResponse> sampleList = Arrays.asList(ytResponse);
    result = CompletableFuture.completedFuture(sampleList);

    CompletableFuture<Result> result1 =  beforeView.process(request,Keyword,result,formFactory,messagesApi);
    Result r1 = result1.get();
    String actualHtml = contentAsString(r1);

    // check the content type of r1 is html.
    assertEquals("text/html", r1.contentType().orElse(""));
    //System.out.println(actualHtml);

    // Check the content contains provided YTResponse in the view.
    assertTrue(actualHtml.contains("Sample Video"));
    assertTrue(actualHtml.contains("12345"));
    assertTrue(actualHtml.contains("https://www.youtube.com/watch?v=12345"));
    assertTrue(actualHtml.contains("Sample Channel"));
    assertTrue(actualHtml.contains("abcde"));
    assertTrue(actualHtml.contains("https://www.youtube.com/channel/abcde"));
    assertTrue(actualHtml.contains("This is the sample description."));
    assertTrue(actualHtml.contains("https://i.ytimg.com/vi/12345/default.jpg"));
}

}




