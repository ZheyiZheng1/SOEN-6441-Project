package actors;
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
}
