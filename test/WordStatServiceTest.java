import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.WordStatService;
import services.YTResponse;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Unit tests for the {@link WordStatService} class.
 * Tests the word frequency and sorting functionalities on YouTube video data.
 * @author Praneet Avhad - 40279347
 */

public class WordStatServiceTest {

    /** Instance of {@link WordStatService} used for testing. */
    private WordStatService videoProcessor;

    /**
     * Initializes the {@link WordStatService} instance before each test case.
     */
    @BeforeEach
    void setUp() {
        videoProcessor = new WordStatService();
    }

    /**
     * Tests {@link WordStatService#getWordFrequency(List)} with an empty video list.
     * Expects an empty map as the result.
     */
    @Test
    void testEmptyList() {
        List<YTResponse> videos = Collections.emptyList();
        Map<String, Long> wordFrequency = videoProcessor.getWordFrequency(videos);
        assertEquals(Collections.emptyMap(), wordFrequency, "Expected empty map for empty video list");
    }

    /**
     * Tests word frequency calculation for a single video with one word in both the title and description.
     * Expects a map with each word appearing once.
     */
    @Test
    void testSingleVideoSingleWord() {
        YTResponse video = new YTResponse();
        video.setTitle("Hello");
        video.setDescription("World");

        Map<String, Long> wordFrequency = videoProcessor.getWordFrequency(Arrays.asList(video));
        assertEquals(Map.of("hello", 1L, "world", 1L), wordFrequency, "Expected map with word counts for single video");
    }

    /**
     * Tests word frequency calculation for a single video with repeated words.
     * Expects a map with correct counts for repeated words.
     */
    @Test
    void testSingleVideoMultipleOccurrences() {
        YTResponse video = new YTResponse();
        video.setTitle("Hello Hello");
        video.setDescription("Hello World");

        Map<String, Long> wordFrequency = videoProcessor.getWordFrequency(Arrays.asList(video));
        assertEquals(Map.of("hello", 3L, "world", 1L), wordFrequency, "Expected correct count for repeated words");
    }

    /**
     * Tests that word frequency calculation is case-insensitive.
     * Expects a map with all words counted regardless of case.
     */
    @Test
    void testCaseInsensitiveCounting() {
        YTResponse video = new YTResponse();
        video.setTitle("Hello hello");
        video.setDescription("HELLO world");

        Map<String, Long> wordFrequency = videoProcessor.getWordFrequency(Arrays.asList(video));
        assertEquals(Map.of("hello", 3L, "world", 1L), wordFrequency, "Expected case-insensitive counting of words");
    }

    /**
     * Tests word frequency calculation for multiple videos with no overlapping words.
     * Expects each unique word to appear once in the result.
     */
    @Test
    void testMultipleVideosNoOverlappingWords() {
        YTResponse video1 = new YTResponse();
        video1.setTitle("Apple");
        video1.setDescription("Orange");

        YTResponse video2 = new YTResponse();
        video2.setTitle("Banana");
        video2.setDescription("Grape");

        Map<String, Long> wordFrequency = videoProcessor.getWordFrequency(Arrays.asList(video1, video2));
        // Expecting two words from each video with count 1
        assertEquals(Map.of("apple", 1L, "orange", 1L, "banana", 1L, "grape", 1L), wordFrequency, "Expected word counts from two non-overlapping videos");
    }

    /**
     * Tests word frequency calculation for multiple videos with overlapping words.
     * Expects combined counts of overlapping words.
     */
    @Test
    void testMultipleVideosWithOverlappingWords() {
        YTResponse video1 = new YTResponse();
        video1.setTitle("Apple Banana");
        video1.setDescription("Apple Grape");

        YTResponse video2 = new YTResponse();
        video2.setTitle("Banana Apple");
        video2.setDescription("Grape Banana");

        Map<String, Long> wordFrequency = videoProcessor.getWordFrequency(Arrays.asList(video1, video2));
        // Expecting combined counts
        assertEquals(Map.of("apple", 3L, "banana", 3L, "grape", 2L), wordFrequency, "Expected correct combined word counts from two overlapping videos");
    }

    /**
     * Tests filtering of single-character words in word frequency calculation.
     * Expects a map with specific counts for single-character words.
     */
    @Test
    void testFilterSingleCharacterWords() {
        YTResponse video = new YTResponse();
        video.setTitle("A I O");
        video.setDescription("I A");

        Map<String, Long> wordFrequency = videoProcessor.getWordFrequency(List.of(video));
        // Check that single characters are either filtered or not counted
        assertEquals(Map.of("i", 2L, "a", 2L, "o", 1L), wordFrequency, "Expected filter for single-character words");
    }


    /**
     * Tests sorting of words by frequency in descending order.
     * Expects a sorted map with words in order of their frequency.
     */
    @Test
    void testSortWordsByFrequency() {
        Map<String, Long> wordFrequency = Map.of(
                "apple", 3L,
                "banana", 1L,
                "grape", 2L
        );

        Map<String, Long> sortedFrequency = videoProcessor.sortWordsByFrequency(wordFrequency);

        // Expected to be sorted by frequency in descending order
        assertEquals(Map.of(
                "apple", 3L,
                "grape", 2L,
                "banana", 1L
        ), sortedFrequency, "Expected words sorted by frequency in descending order");
    }

    /**
     * Tests handling of words with non-alphabetic characters.
     * Expects numbers and special characters to be properly handled or filtered.
     */
    @Test
    void testWordsWithNonAlphabeticCharacters() {
        YTResponse video = new YTResponse();
        video.setTitle("Hello 123");
        video.setDescription("Test! Test...");

        Map<String, Long> wordFrequency = videoProcessor.getWordFrequency(Arrays.asList(video));
        // Check that numbers and special characters are properly handled (filtered or not counted)
        assertEquals(Map.of("hello", 1L, "test", 2L), wordFrequency, "Expected proper handling of non-alphabetic characters");
    }
}
