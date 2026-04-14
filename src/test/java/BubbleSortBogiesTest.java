import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BubbleSortBogiesTest {

    private BubbleSortBogies sorter;

    @BeforeEach
    public void setUp() {
        sorter = new BubbleSortBogies();
    }

    @Test
    public void testSort_BasicSorting() {
        int[] input = {72, 56, 24, 70, 60};
        int[] expected = {24, 56, 60, 70, 72};
        int[] actual = sorter.sortCapacities(input);
        assertEquals(true, Arrays.equals(expected, actual));
    }

    @Test
    public void testSort_AlreadySortedArray() {
        int[] input = {24, 56, 60, 70, 72};
        int[] expected = {24, 56, 60, 70, 72};
        int[] actual = sorter.sortCapacities(input);
        assertEquals(true, Arrays.equals(expected, actual));
    }

    @Test
    public void testSort_DuplicateValues() {
        int[] input = {72, 56, 56, 24};
        int[] expected = {24, 56, 56, 72};
        int[] actual = sorter.sortCapacities(input);
        assertEquals(true, Arrays.equals(expected, actual));
    }

    @Test
    public void testSort_SingleElementArray() {
        int[] input = {50};
        int[] expected = {50};
        int[] actual = sorter.sortCapacities(input);
        assertEquals(true, Arrays.equals(expected, actual));
    }

    @Test
    public void testSort_AllEqualValues() {
        int[] input = {40, 40, 40};
        int[] expected = {40, 40, 40};
        int[] actual = sorter.sortCapacities(input);
        assertEquals(true, Arrays.equals(expected, actual));
    }
}
