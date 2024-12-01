package Model;

/**
 * Message class for requesting tags related to a specific keyword
 * This class is used for communication between actors.
 *
 * @author: Pulkit Bansal - 40321488
 * Created: 2024/11/22
 */

public class FetchTags {
    public final String keyword;


    /**
     * Constructor for FetchTags.
     *
     * @param keyword The keyword for which tags are requested.
     */

    public FetchTags(String keyword) {
        this.keyword = keyword;
    }
}
