package actors;

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
}
