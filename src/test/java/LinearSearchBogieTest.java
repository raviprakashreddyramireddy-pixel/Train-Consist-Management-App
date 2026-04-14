import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinearSearchBogieTest {

    private LinearSearchBogie searcher;
    private String[] bogieIds;

    @BeforeEach
    public void setUp() {
        searcher = new LinearSearchBogie();
        bogieIds = new String[]{"BG101", "BG205", "BG309", "BG412", "BG550"};
    }

    @Test
    public void testSearch_BogieFound() {
        boolean actual = searcher.searchBogie(bogieIds, "BG309");
        assertEquals(true, actual);
    }

    @Test
    public void testSearch_BogieNotFound() {
        boolean actual = searcher.searchBogie(bogieIds, "BG999");
        assertEquals(false, actual);
    }

    @Test
    public void testSearch_FirstElementMatch() {
        boolean actual = searcher.searchBogie(bogieIds, "BG101");
        assertEquals(true, actual);
    }

    @Test
    public void testSearch_LastElementMatch() {
        boolean actual = searcher.searchBogie(bogieIds, "BG550");
        assertEquals(true, actual);
    }

    @Test
    public void testSearch_SingleElementArray() {
        String[] single = {"BG101"};
        boolean actual = searcher.searchBogie(single, "BG101");
        assertEquals(true, actual);
    }
}
