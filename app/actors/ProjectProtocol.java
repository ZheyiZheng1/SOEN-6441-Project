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
        /**
         * @author: Zheyi Zheng - 40266266
         * Created: 2024/11/11
         * Constructor method.
         * @param keyword string of keyword that user want to search.
         */
        public KeyWordSearch(String keyword) {
            this.keyword = keyword;
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
}
