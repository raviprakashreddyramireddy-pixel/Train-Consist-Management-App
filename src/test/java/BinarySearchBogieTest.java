import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchBogieTest {

    private BinarySearchBogie searcher;
    private String[] sortedBogies;

    @BeforeEach
    public void setUp() {
        searcher = new BinarySearchBogie();
        sortedBogies = new String[]{"BG101", "BG205", "BG309", "BG412", "BG550"};
    }

    @Test
    public void testBinarySearch_BogieFound() {
        boolean actual = searcher.searchBogie(sortedBogies, "BG309");
        assertEquals(true, actual);
    }

    @Test
    public void testBinarySearch_BogieNotFound() {
        boolean actual = searcher.searchBogie(sortedBogies, "BG999");
        assertEquals(false, actual);
    }

    @Test
    public void testBinarySearch_FirstElementMatch() {
        boolean actual = searcher.searchBogie(sortedBogies, "BG101");
        assertEquals(true, actual);
    }

    @Test
    public void testBinarySearch_LastElementMatch() {
        boolean actual = searcher.searchBogie(sortedBogies, "BG550");
        assertEquals(true, actual);
    }

    @Test
    public void testBinarySearch_SingleElementArray() {
        String[] single = {"BG101"};
        boolean actual = searcher.searchBogie(single, "BG101");
        assertEquals(true, actual);
    }

    @Test
    public void testBinarySearch_EmptyArray() {
        String[] emptyArr = {};
        boolean actual = searcher.searchBogie(emptyArr, "BG101");
        assertEquals(false, actual);
    }

    @Test
    public void testBinarySearch_UnsortedInputHandled() {
        String[] unsorted = {"BG309", "BG101", "BG550", "BG205", "BG412"};
        boolean actual = searcher.searchBogie(unsorted, "BG205");
        assertEquals(true, actual);
    }
}
