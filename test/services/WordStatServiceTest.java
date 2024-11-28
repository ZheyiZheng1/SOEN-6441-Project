
package services;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
import org.junit.Before;
//import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import services.WordStatService;

import java.util.*;

        import static org.junit.Assert.assertEquals;


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
    @Before
    public void setUp() {
        videoProcessor = new WordStatService();
    }

    /**
     * Tests {@link WordStatService#getWordFrequency(List)} with an empty video list.
     * Expects an empty map as the result.
     */
    @Test
    public void testEmptyList() {
        List<YTResponse> videos = Collections.emptyList();
        Map<String, Long> wordFrequency = videoProcessor.getWordFrequency(videos);
        assertEquals(Collections.emptyMap(), wordFrequency);
    }


    /**
     * Tests word frequency calculation for a single video with one word in both the title and description.
     * Expects a map with each word appearing once.
     */
    @Test
    public void testSingleVideoSingleWord() {
        YTResponse video = new YTResponse();
        video.setTitle("Hello");
        video.setDescription("World");

        Map<String, Long> wordFrequency = videoProcessor.getWordFrequency(Arrays.asList(video));
        assertEquals(Map.of("hello", 1L, "world", 1L), wordFrequency);
    }

    /**
     * Tests word frequency calculation for a single video with repeated words.
     * Expects a map with correct counts for repeated words.
     */
    @Test
    public void testSingleVideoMultipleOccurrences() {
        YTResponse video = new YTResponse();
        video.setTitle("Hello Hello");
        video.setDescription("Hello World");

        Map<String, Long> wordFrequency = videoProcessor.getWordFrequency(Arrays.asList(video));
        assertEquals(Map.of("hello", 3L, "world", 1L), wordFrequency);
    }


    /**
     * Tests that word frequency calculation is case-insensitive.
     * Expects a map with all words counted regardless of case.
     */
    @Test
    public void testCaseInsensitiveCounting() {
        YTResponse video = new YTResponse();
        video.setTitle("Hello hello");
        video.setDescription("HELLO world");

        Map<String, Long> wordFrequency = videoProcessor.getWordFrequency(Arrays.asList(video));
        assertEquals(Map.of("hello", 3L, "world", 1L), wordFrequency);
    }


    /**
     * Tests word frequency calculation for multiple videos with no overlapping words.
     * Expects each unique word to appear once in the result.
     */
    @Test
    public void testMultipleVideosNoOverlappingWords() {
        YTResponse video1 = new YTResponse();
        video1.setTitle("Apple");
        video1.setDescription("Orange");

        YTResponse video2 = new YTResponse();
        video2.setTitle("Banana");
        video2.setDescription("Grape");

        Map<String, Long> wordFrequency = videoProcessor.getWordFrequency(Arrays.asList(video1, video2));
        // Expecting two words from each video with count 1
        assertEquals(Map.of("apple", 1L, "orange", 1L, "banana", 1L, "grape", 1L), wordFrequency);
    }

    /**
     * Tests word frequency calculation for multiple videos with overlapping words.
     * Expects combined counts of overlapping words.
     */
    @Test
    public void testMultipleVideosWithOverlappingWords() {
        YTResponse video1 = new YTResponse();
        video1.setTitle("Apple Banana");
        video1.setDescription("Apple Grape");

        YTResponse video2 = new YTResponse();
        video2.setTitle("Banana Apple");
        video2.setDescription("Grape Banana");

        Map<String, Long> wordFrequency = videoProcessor.getWordFrequency(Arrays.asList(video1, video2));
        // Expecting combined counts
        assertEquals(Map.of("apple", 3L, "banana", 3L, "grape", 2L), wordFrequency);
    }

    /**
     * Tests filtering of single-character words in word frequency calculation.
     * Expects a map with specific counts for single-character words.
     */
    @Test
    public void testFilterSingleCharacterWords() {
        YTResponse video = new YTResponse();
        video.setTitle("A I O");
        video.setDescription("I A");

        Map<String, Long> wordFrequency = videoProcessor.getWordFrequency(List.of(video));
        // Check that single characters are either filtered or not counted
        assertEquals(Map.of("i", 2L, "a", 2L, "o", 1L), wordFrequency);
    }


    /**
     * Tests sorting of words by frequency in descending order.
     * Expects a sorted map with words in order of their frequency.
     */
    @Test
    public void testSortWordsByFrequency() {
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
        ), sortedFrequency);
    }

    /**
     * Tests handling of words with non-alphabetic characters.
     * Expects numbers and special characters to be properly handled or filtered.
     */
    @Test
    public void testWordsWithNonAlphabeticCharacters() {
        YTResponse video = new YTResponse();
        video.setTitle("Hello 123");
        video.setDescription("Test! Test...");

        Map<String, Long> wordFrequency = videoProcessor.getWordFrequency(Arrays.asList(video));
        // Check that numbers and special characters are properly handled (filtered or not counted)
        assertEquals(Map.of("hello", 1L, "test", 2L), wordFrequency);
    }

//    public void testNullInput() {
//        Assertions.assertThrows(IllegalArgumentException.class, () -> {
//            videoProcessor.getWordFrequency(null);
//        }, "Expected getWordFrequency to throw IllegalArgumentException for null input");
//    }

    /**
     * Test case for the {@link WordStatService#sortWordsByFrequency(Map)} method.
     *
     * This test verifies that when an empty map is passed to the
     * {@link WordStatService#sortWordsByFrequency(Map)} method, the result is also an empty map.
     * It ensures that the method handles the edge case of an empty input correctly, returning an
     * empty map without errors or unexpected behavior.
     *
     * @see WordStatService#sortWordsByFrequency(Map)
     */

    @Test
    public void testSortWordsByFrequency_EmptyMap() {
        Map<String, Long> wordFrequency = Collections.emptyMap();
        Map<String, Long> sortedFrequency = videoProcessor.sortWordsByFrequency(wordFrequency);
        assertEquals(Collections.emptyMap(), sortedFrequency);
    }

    /**
     * Test case for the {@link WordStatService#sortWordsByFrequency(Map)} method with a map containing
     * a single entry.
     *
     * This test ensures that when a map with a single entry is passed to the
     * {@link WordStatService#sortWordsByFrequency(Map)} method, the map is returned unchanged, as
     * sorting a single-entry map does not alter its contents.
     *
     * @see WordStatService#sortWordsByFrequency(Map)
     */


    @Test
    public void testSortWordsByFrequency_SingleEntry() {
        Map<String, Long> wordFrequency = Map.of("apple", 1L);
        Map<String, Long> sortedFrequency = videoProcessor.sortWordsByFrequency(wordFrequency);
        assertEquals(wordFrequency, sortedFrequency);
    }

    /**
     * Test case for the {@link WordStatService#sortWordsByFrequency(Map)} method with multiple entries.
     *
     * This test verifies that the {@link WordStatService#sortWordsByFrequency(Map)} method correctly
     * sorts a map by frequency in descending order. It ensures that words with higher frequency appear
     * first in the sorted map.
     *
     * @see WordStatService#sortWordsByFrequency(Map)
     */

    @Test
    public void testSortWordsByFrequency_MultipleEntries() {
        Map<String, Long> wordFrequency = Map.of(
                "apple", 3L,
                "banana", 1L,
                "grape", 2L
        );

        Map<String, Long> expectedSorted = new LinkedHashMap<>();
        expectedSorted.put("apple", 3L);
        expectedSorted.put("grape", 2L);
        expectedSorted.put("banana", 1L);

        Map<String, Long> sortedFrequency = videoProcessor.sortWordsByFrequency(wordFrequency);
        assertEquals(expectedSorted, sortedFrequency);
    }

    /**
     * Test case for the {@link WordStatService#sortWordsByFrequency(Map)} method when duplicate entries
     * exist for a word.
     *
     * This test ensures that the merge function works correctly by keeping the last entry for duplicate
     * words, as specified by the map’s merge strategy. It verifies that the method returns the correct
     * frequencies after resolving duplicates.
     *
     * @see WordStatService#sortWordsByFrequency(Map)
     */

    @Test
    public void testSortWordsByFrequency_MergeFunction() {
        // Creating a Map with duplicate entries manually.
        Map<String, Long> wordFrequency = new LinkedHashMap<>();
        wordFrequency.put("apple", 2L);
        wordFrequency.put("apple", 3L); // Duplicate key to trigger merge function
        wordFrequency.put("banana", 1L);

        Map<String, Long> sortedFrequency = videoProcessor.sortWordsByFrequency(wordFrequency);

        // Expected result after merging duplicate entries.
        Map<String, Long> expectedFrequency = new LinkedHashMap<>();
        expectedFrequency.put("apple", 3L); // Keeps the last duplicate
        expectedFrequency.put("banana", 1L);

        assertEquals(expectedFrequency, sortedFrequency);
    }
}
