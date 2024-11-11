/*
 * ChannelProfile Test file
 * @author Sakshi Mulik - 40295793
 * */


package services;

import com.google.common.collect.ImmutableMap;
import controllers.HomeController;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import play.Application;
import play.mvc.Http;
import play.mvc.Result;
import play.test.Helpers;

import static org.junit.jupiter.api.Assertions.*;
import static play.mvc.Http.Status.*;
import static play.test.Helpers.*;

public class ChannelProfileTest {

    @InjectMocks
    private HomeController homeController;

    private Application app;

    @BeforeEach
    public void setup() {
        // Initializeing  mocks and controllers
        // Create the fake application context
        app = Helpers.fakeApplication();
        Helpers.start(app);  // Start the application
    }

    // Test Case 1: Verify Channel Page Loads Correctly
    @Test
    public void testChannelPageLoadsCorrectly() {
        String channelId = "UCBR8-60-B28hp2BmDPdntcQ";

        // Simulate calling the controller action
        Result result = homeController.showChannelProfile(channelId);

        // Check if the page loads correctly (HTTP Status 200 OK)
        assertEquals(OK, result.status());

        // Check if the page contains expected profile information
        String pageContent = contentAsString(result);
        assertTrue(pageContent.contains("Channel Title"));
        assertTrue(pageContent.contains("Channel Description"));
        assertTrue(pageContent.contains("Video count"));
    }

    // Test Case 2: Verify Channel Hyperlink from Search Results
    @Test
    public void testChannelHyperlinkFromSearchResults() {
        String keyword = "cat videos";
        String channelLink = "/channel/UCBR8-60-B28hp2BmDPdntcQ";

        // Build a request for the search endpoint with the keyword
        Http.RequestBuilder request = new Http.RequestBuilder()
                .method("POST")
                .uri("/search")
                .bodyForm(ImmutableMap.of("keyword", keyword));

        // Execute the search and get the result using the application context
        Result result = route(app, request);

        // Check that the result contains the correct channel hyperlink
        String pageContent = contentAsString(result);
        assertTrue(pageContent.contains(channelLink));
    }

    // Test Case 3: Verify Missing Channel Profile Data
    @Test
    public void testMissingChannelProfileData() {
        String channelId = "MissingDataChannel";

        // Simulate calling the controller action for a channel with missing data
        Result result = homeController.showChannelProfile(channelId);

        // Check if the page loads with HTTP Status 200 (OK)
        assertEquals(OK, result.status());

        // Check for placeholder message for missing data
        String pageContent = contentAsString(result);
        assertTrue(pageContent.contains("No description available"));
        assertTrue(pageContent.contains("No video data available"));
    }

    // Test Case 4: Verify Channel Profile Page Responsiveness
    @Test
    public void testResponsiveDesign() {
        String channelId = "UCBR8-60-B28hp2BmDPdntcQ";

        // Simulate calling the controller action
        Result result = homeController.showChannelProfile(channelId);

        // Check that the page loads with the correct HTTP Status
        assertEquals(OK, result.status());

        // Check that the page has responsive content (i.e., no large fixed width elements)
        String pageContent = contentAsString(result);
        assertTrue(pageContent.contains("meta name=\"viewport\""));
        assertTrue(pageContent.contains("channel profile"));
    }

    // Test Case 5: Verify Channel Profile Page with Invalid Channel ID
    @Test
    public void testInvalidChannelId() {
        String invalidChannelId = "InvalidChannel123";

        // Simulate calling the controller action for an invalid channel ID
        Result result = homeController.showChannelProfile(invalidChannelId);

        // Check if the status is HTTP 404 (Not Found)
        assertEquals(NOT_FOUND, result.status());

        // Optionally, check if the page shows an error message for invalid channel
        String pageContent = contentAsString(result);
        assertTrue(pageContent.contains("Channel not found"));
    }

    // Cleanup after tests
    @AfterEach
    public void tearDown() {
        Helpers.stop(app);
    }
}
