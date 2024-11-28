package actors;

import akka.actor.ActorRef;
import services.YTResponse;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author: Zheyi Zheng - 40266266
 * Created: 2024/11/11
 * This is the ProjectProtocol class. This class contains all the messages classes.
 */
public class ProjectProtocol {
    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/11/11
     * This is the KeyWordSearch class. This is a message class that only pass keyword.
     * This class only gets used when controller want to pass keyword to actor to perform search action.
     */
    public static class KeyWordSearch {
        public final String keyword;
        public final String url;
        public final String maxResult;
        /**
         * @author: Zheyi Zheng - 40266266
         * Created: 2024/11/11
         * Constructor method.
         * @param keyword string of keyword that user want to search.
         */
        public KeyWordSearch(String keyword, String url, String maxResult) {
            this.keyword = keyword;
            this.url = url;
            this.maxResult = maxResult;
        }
    }

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/11/11
     * This is the ReadabilityCheck class. This is a message class that only pass CompletableFuture<List<YTResponse>>.
     * This class only gets used when controller want to pass search result to actor to get readability information.
     */
    public static class ReadabilityCheck {
        public final CompletableFuture<List<YTResponse>> result;
        /**
         * @author: Zheyi Zheng - 40266266
         * Created: 2024/11/11
         * Constructor method.
         * @param result CompletableFuture<List<YTResponse>> that should get readability level checked.
         */
        public ReadabilityCheck(CompletableFuture<List<YTResponse>> result) {
            this.result = result;
        }
    }

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/11/25
     * This is the ReadabilityCheck class. This is a message class that only pass CompletableFuture<List<YTResponse>> and keyword.
     * This class only gets used when WebSocketActor want to update readability.
     */
    public static class ReadabilityUpdate {
        public final CompletableFuture<List<YTResponse>> result;
        public final String keyword;
        /**
         * @author: Zheyi Zheng - 40266266
         * Created: 2024/11/11
         * Constructor method.
         * @param result CompletableFuture<List<YTResponse>> that should get readability level checked.
         */
        public ReadabilityUpdate(CompletableFuture<List<YTResponse>> result, String keyword) {
            this.result = result;
            this.keyword = keyword;
        }
    }

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/11/11
     * This is the ReadabilityResponse class. This is a message class that only pass readability information result back.
     */
    public static class ReadabilityResponse {
        //Flesch Reading Ease Score
        public final List<Double> fre;
        //Flesch-Kincaid Grade Level
        public final List<Double> fkgl;

        public final Double avgFRE;
        public final Double avgFKGL;
        /**
         * @author: Zheyi Zheng - 40266266
         * Created: 2024/11/11
         * Constructor method.
         * @param fre Flesch Reading Ease Score. fkgl Flesch-Kincaid Grade Level. avgFRE average Flesch Reading Ease Score. avgFKGL average Flesch-Kincaid Grade Level
         */
        public ReadabilityResponse(List<Double> fre, List<Double> fkgl, Double avgFRE, Double avgFKGL) {
            this.fre = fre;
            this.fkgl = fkgl;
            this.avgFRE = avgFRE;
            this.avgFKGL = avgFKGL;
        }
    }

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/11/25
     * This is the ReadabilityResponse class. This is a message class that only pass readability information result back.
     */
    public static class ReadabilityUpdateResponse {
        //Flesch Reading Ease Score
        public final List<Double> fre;
        //Flesch-Kincaid Grade Level
        public final List<Double> fkgl;

        public final Double avgFRE;
        public final Double avgFKGL;
        public final String keyword;
        /**
         * @author: Zheyi Zheng - 40266266
         * Created: 2024/11/11
         * Constructor method.
         * @param fre Flesch Reading Ease Score. fkgl Flesch-Kincaid Grade Level. avgFRE average Flesch Reading Ease Score. avgFKGL average Flesch-Kincaid Grade Level
         */
        public ReadabilityUpdateResponse(List<Double> fre, List<Double> fkgl, Double avgFRE, Double avgFKGL, String keyword) {
            this.fre = fre;
            this.fkgl = fkgl;
            this.avgFRE = avgFRE;
            this.avgFKGL = avgFKGL;
            this.keyword = keyword;
        }
    }

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/11/11
     * This is the ErrorMessage class. This class is used to pass error message between actors.
     */
    public static class ErrorMessage {
        public final String message;
        /**
         * @author: Zheyi Zheng - 40266266
         * Created: 2024/11/11
         * Constructor method.
         * @param message a string that contains error information.
         */
        public ErrorMessage(String message) {
            this.message = message;
        }
    }

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/11/11
     * This is the UpdateApiAndReadabilityRef class. This class is used to pass APIActor and ReadabilityActor to WebSocketActors.
     * This message should not be used other than test purpose.
     */
    public static class UpdateApiAndReadabilityRef {
        public final ActorRef apiActor;
        public final ActorRef readabilityActor;
        /**
         * @author: Zheyi Zheng - 40266266
         * Created: 2024/11/11
         * Constructor method.
         * @param apiActor a APIActor's ActorRef. readabilityActor's ActorRef
         */
        public UpdateApiAndReadabilityRef(ActorRef apiActor, ActorRef readabilityActor) {
            this.apiActor = apiActor;
            this.readabilityActor = readabilityActor;
        }
    }

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/11/25
     * This is the UpdateDataRequest class. This class is used to let APIActor to check if there is any update on existing data.
     */
    public static class UpdateDataRequest {
        public final String keyword;
        public final String url;
        public final String maxResult;
        /**
         * @author: Zheyi Zheng - 40266266
         * Created: 2024/11/25
         * Constructor method.
         * @param keyword string of keyword that user want to search.
         */
        public UpdateDataRequest(String keyword, String url, String maxResult) {
            this.keyword = keyword;
            this.url = url;
            this.maxResult = maxResult;
        }
    }

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/11/11
     * This is the UpdateApiAndReadabilityRef class. This class is used to pass APIActor and ReadabilityActor to WebSocketActors.
     * This message should not be used other than test purpose.
     */
    public static class UpdateDataResponse {
        public final CompletableFuture<List<YTResponse>> updatedData;
        public final String keyword;
        /**
         * @author: Zheyi Zheng - 40266266
         * Created: 2024/11/11
         * Constructor method.
         * @param updatedData a completeableFuture that will contains all updated data respect to certain keyword.
         */
        public UpdateDataResponse(CompletableFuture<List<YTResponse>>updatedData, String keyword) {
            this.updatedData = updatedData;
            this.keyword = keyword;
        }
    }

        public static class SentimentCheck {
        public final CompletableFuture<List<YTResponse>> input;
        /**
         * @author: Jiaxi Liu - 40278106
         * Created: 2024/11/27
         * This is a Constructor method used to pass the input value to SentimentActor
         * @param  Input is the search result
         */
        public SentimentCheck(CompletableFuture<List<YTResponse>> Input)
        {
            this.input = Input;
        }

    }

    public static class SentimentResponse{
        public final String sentiment;
        /**
         * @author: Jiaxi Liu - 40278106
         * Created: 2024/11/27
         * This is a Constructor method used to pass the output value to WebsocketActor
         * @param  sentiment is the final result after calculating
         */
        public SentimentResponse(String sentiment) {
            this.sentiment = sentiment;
        }
    }

        public static class SentimentUpdate {
        public final CompletableFuture<List<YTResponse>> input;
        /**
         * @author: Jiaxi Liu - 40278106
         * Created: 2024/11/27
         * This is a Constructor method used to pass the input value to SentimentActor
         * @param  Input is the updated data
         */
        public SentimentUpdate(CompletableFuture<List<YTResponse>> Input)
        {
            this.input = Input;
        }
    }

    public static class SentimentUpdateResponse {
        public final String Sentiment;
        /**
         * @author: Jiaxi Liu - 40278106
         * Created: 2024/11/27
         * This is a Constructor method used to pass the input value to WebsocketActor
         * @param  Input is the updated sentiment
         */
        public SentimentUpdateResponse(String Input){
            this.Sentiment = Input;
        }
    }
}
