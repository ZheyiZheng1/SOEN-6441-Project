/**
 * @author: Zheyi Zheng - 40266266
 * Created: 2024/10/29
 * This is a test class for SearchForm.
 */
package Model;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchFormTest {
    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/11/9
     * Test all methods in SearchForm
     */
    @Test
    public void testSearchVForm() throws Exception {
        SearchForm searchForm = new SearchForm();
        searchForm.setKeyword("keyword");
        assertEquals("keyword", searchForm.getKeyword());
    }
}
