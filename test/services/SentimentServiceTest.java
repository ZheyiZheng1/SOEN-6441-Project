package services;


import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SentimentServiceTest {

    /**
     * @author: Jiaxi Liu - 40278106
     * Created: 2024/11/6
     * Test if the function countHappyWords can count positive words correctly
     */
@Test
    public void testcountHappyWords(){
    //Initialize
    SentimentService sentimentService;
    String[] Words;
    YTResponse mock1 = new YTResponse();
    String Description1 = "happy joyful disappointed blissful cheerful defeated satisfied relaxed fulfilled surprised peaceful eager.";
    mock1.setDescription(Description1);
    Words = Description1.split(" ");
    List<YTResponse> mockList = new ArrayList<>();
    mockList.add(mock1);
    CompletableFuture<List<YTResponse>> Input = CompletableFuture.completedFuture(mockList);
    sentimentService = new SentimentService(Input);


    int NumHappy = sentimentService.countHappyWords(Words);
    assertEquals(10,NumHappy);
}

    /**
     * @author: Jiaxi Liu - 40278106
     * Created: 2024/11/6
     * Test if the function countSadWords can count negative words correctly
     */
@Test
    public void testcountSadWords(){
    //Initialize
    SentimentService sentimentService;
    String[] Words;
    YTResponse mock1 = new YTResponse();
    String Description1 = "happy joyful disappointed blissful cheerful defeated satisfied relaxed fulfilled surprised peaceful eager.";
    mock1.setDescription(Description1);
    Words = Description1.split(" ");
    List<YTResponse> mockList = new ArrayList<>();
    mockList.add(mock1);
    CompletableFuture<List<YTResponse>> Input = CompletableFuture.completedFuture(mockList);
    sentimentService = new SentimentService(Input);


    int NumSad = sentimentService.countSadWords(Words);
    assertEquals(2,NumSad);

}

    /**
     * @author: Jiaxi Liu - 40278106
     * Created: 2024/11/6
     * Test if the function IfContain can tell if the given word is contained in the array
     */
@Test
    public void testIfContainTrue(){
    //Initialize
    SentimentService sentimentService;
    String[] Words;
    YTResponse mock1 = new YTResponse();
    String Description1 = "happy joyful disappointed blissful cheerful defeated satisfied relaxed fulfilled surprised peaceful eager.";
    mock1.setDescription(Description1);
    Words = Description1.split(" ");
    List<YTResponse> mockList = new ArrayList<>();
    mockList.add(mock1);
    CompletableFuture<List<YTResponse>> Input = CompletableFuture.completedFuture(mockList);
    sentimentService = new SentimentService(Input);


    boolean Ifcontai1 = sentimentService.IfContain("peaceful",Words);
    assertEquals(true,Ifcontai1);
}
@Test
    public void testIfContainFalse(){
    //Initialize
    SentimentService sentimentService;
    String[] Words;
    YTResponse mock1 = new YTResponse();
    String Description1 = "happy joyful disappointed blissful cheerful defeated satisfied relaxed fulfilled surprised peaceful eager.";
    mock1.setDescription(Description1);
    Words = Description1.split(" ");
    List<YTResponse> mockList = new ArrayList<>();
    mockList.add(mock1);
    CompletableFuture<List<YTResponse>> Input = CompletableFuture.completedFuture(mockList);
    sentimentService = new SentimentService(Input);


    boolean Ifcontai1 = sentimentService.IfContain("computer",Words);
    assertEquals(false,Ifcontai1);
}

    /**
     * @author: Jiaxi Liu - 40278106
     * Created: 2024/11/6
     * Test if the function IfContain can output the symbol correctly when the description is positive
     */
@Test
    public void testsetFinalOutputHappy(){
    //Initialize
    SentimentService sentimentService;
    String[] Words;
    YTResponse mock1 = new YTResponse();
    String Description1 = "happy joyful disappointed blissful cheerful defeated satisfied relaxed fulfilled surprised peaceful eager.";
    mock1.setDescription(Description1);
    Words = Description1.split(" ");
    List<YTResponse> mockList = new ArrayList<>();
    mockList.add(mock1);
    CompletableFuture<List<YTResponse>> Input = CompletableFuture.completedFuture(mockList);
    sentimentService = new SentimentService(Input);


    sentimentService.setFinalOutput(100.0,70.0,30.0);
    assertEquals(":-)",sentimentService.FinalOutput);
}

    /**
     * @author: Jiaxi Liu - 40278106
     * Created: 2024/11/6
     * Test if the function IfContain can output the symbol correctly when the description is negative
     */
    @Test
    public void testsetFinalOutputSad(){
        //Initialize
        SentimentService sentimentService;
        String[] Words;
        YTResponse mock1 = new YTResponse();
        String Description1 = "happy joyful disappointed blissful cheerful defeated satisfied relaxed fulfilled surprised peaceful eager.";
        mock1.setDescription(Description1);
        Words = Description1.split(" ");
        List<YTResponse> mockList = new ArrayList<>();
        mockList.add(mock1);
        CompletableFuture<List<YTResponse>> Input = CompletableFuture.completedFuture(mockList);
        sentimentService = new SentimentService(Input);


        sentimentService.setFinalOutput(100.0,30.0,70.0);
        assertEquals(":-(",sentimentService.FinalOutput);
    }

    /**
     * @author: Jiaxi Liu - 40278106
     * Created: 2024/11/6
     * Test if the function IfContain can output the symbol correctly when the description is neutral
     */
    @Test
    public void testsetFinalOutputNeutral(){
        //Initialize
        SentimentService sentimentService;
        String[] Words;
        YTResponse mock1 = new YTResponse();
        String Description1 = "happy joyful disappointed blissful cheerful defeated satisfied relaxed fulfilled surprised peaceful eager.";
        mock1.setDescription(Description1);
        Words = Description1.split(" ");
        List<YTResponse> mockList = new ArrayList<>();
        mockList.add(mock1);
        CompletableFuture<List<YTResponse>> Input = CompletableFuture.completedFuture(mockList);
        sentimentService = new SentimentService(Input);


        sentimentService.setFinalOutput(100.0,50.0,50.0);
        assertEquals(":-|",sentimentService.FinalOutput);
    }

    @Test
    public void getFinalOutputTest() {
        //Initialize
        SentimentService sentimentService;
        String[] Words;
        YTResponse mock1 = new YTResponse();
        String Description1 = "happy joyful disappointed blissful cheerful defeated satisfied relaxed fulfilled surprised peaceful eager.";
        mock1.setDescription(Description1);
        Words = Description1.split(" ");
        List<YTResponse> mockList = new ArrayList<>();
        mockList.add(mock1);
        CompletableFuture<List<YTResponse>> Input = CompletableFuture.completedFuture(mockList);
        sentimentService = new SentimentService(Input);


        assertEquals(":-)",sentimentService.getFinalOutput());

    }


}
