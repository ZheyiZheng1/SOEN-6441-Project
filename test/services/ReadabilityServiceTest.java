/**
 * @author: Zheyi Zheng - 40266266
 * Created: 2024/10/30
 * This is the test class for ReadabilityService.
 *
 */
package services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReadabilityServiceTest {
    private ReadabilityService readabilityService;

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/10/30
     * Before each test, create three mock responses, create CompletableFuture for those response then create the readabilityService for calculation.
     *
     */
    @BeforeEach
    public void setUp() {

        // Create mock data
        YTResponse first = new YTResponse();
        YTResponse second = new YTResponse();
        YTResponse third = new YTResponse();
        // Based on the provided calculator link, fkgl=2.9, fre=83.3
        first.setDescription("This is the first description.");
        // Based on the provided calculator link, fkgl=5.2, fre=66.4
        second.setDescription("This is the second description! This is the second description!");
        // Based on the provided calculator link, fkgl=2.9, fre=83.3
        third.setDescription("This is the third description? This is the third description? This is the third description?");
        // Therefore, the average should be (83.3+66.4+83.3)/3 = 77.6666666667
        List<YTResponse> mockData = Arrays.asList(first, second, third);

        // Wrap CompletableFuture to the list of YTResponse
        CompletableFuture<List<YTResponse>> future = CompletableFuture.completedFuture(mockData);

        // Initialize ReadabilityService with the mock data
        readabilityService = new ReadabilityService(future);
    }

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/10/29
     * Test getFreAndValue method. Make sure all calculated value matches what I got from the website.
     */
    @Test
    public void testGetFreAndValue(){
        List<Double> response = readabilityService.getFre();
        List<Double> list = Arrays.asList(83.3, 66.4, 83.3);
        assertEquals(list, response);
    }

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/10/29
     * Test getFkglAndValue method. Make sure all calculated value matches what I got from the website.
     */
    @Test
    public void testGetFkglAndValue(){
        List<Double> response = readabilityService.getFkgl();
        List<Double> list = Arrays.asList(2.9, 5.2, 2.9);
        assertEquals(list, response);
    }

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/10/29
     * Test getReadabilityAverage method. Make sure average value was calculated correctly.
     */
    @Test
    public void testGetAvgFRE(){
        double response = readabilityService.getAvgFRE();
        assertEquals((83.3+66.4+83.3)/3, response);
    }

    /**
     * @author: Zheyi Zheng - 40266266
     * Created: 2024/10/29
     * Test getReadabilityAverage method. Make sure average value was calculated correctly.
     */
    @Test
    public void testGetAvgFKGL(){
        double response = readabilityService.getAvgFKGL();
        assertEquals((2.9+5.2+2.9)/3, response);
    }
}
