import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BogieNameSorterTest {

    private BogieNameSorter sorter;

    @BeforeEach
    public void setUp() {
        sorter = new BogieNameSorter();
    }

    @Test
    public void testSort_BasicAlphabeticalSorting() {
        String[] input = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};
        String[] expected = {"AC Chair", "First Class", "General", "Luxury", "Sleeper"};
        String[] actual = sorter.sortNames(input);
        assertEquals(true, Arrays.equals(expected, actual));
    }

    @Test
    public void testSort_UnsortedInput() {
        String[] input = {"Luxury", "General", "Sleeper", "AC Chair"};
        String[] expected = {"AC Chair", "General", "Luxury", "Sleeper"};
        String[] actual = sorter.sortNames(input);
        assertEquals(true, Arrays.equals(expected, actual));
    }

    @Test
    public void testSort_AlreadySortedArray() {
        String[] input = {"AC Chair", "First Class", "General"};
        String[] expected = {"AC Chair", "First Class", "General"};
        String[] actual = sorter.sortNames(input);
        assertEquals(true, Arrays.equals(expected, actual));
    }

    @Test
    public void testSort_DuplicateBogieNames() {
        String[] input = {"Sleeper", "AC Chair", "Sleeper", "General"};
        String[] expected = {"AC Chair", "General", "Sleeper", "Sleeper"};
        String[] actual = sorter.sortNames(input);
        assertEquals(true, Arrays.equals(expected, actual));
    }

    @Test
    public void testSort_SingleElementArray() {
        String[] input = {"Sleeper"};
        String[] expected = {"Sleeper"};
        String[] actual = sorter.sortNames(input);
        assertEquals(true, Arrays.equals(expected, actual));
    }
}
