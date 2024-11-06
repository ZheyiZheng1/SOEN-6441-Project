package Model;

/**
 * Basic model class that only keeps a keyword. It is a simple model type that use for pass form from controller to view.
 * @author: Zheyi Zheng - 40266266
 * Created: 2024/10/24
 */
public class SearchForm {

    private String keyword;
    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/10/24
     * @return the keyword.
     */
    public String getKeyword() {
        return keyword;
    }
    /**
     * Set the keyword
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/10/24
     * @param keyword a string
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
