import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SafeBogieSearchTest {

    private SafeBogieSearch searcher;

    @BeforeEach
    public void setUp() {
        searcher = new SafeBogieSearch();
    }

    @Test
    public void testSearch_ThrowsExceptionWhenEmpty() {
        boolean exceptionThrown = false;
        try {
            searcher.searchBogie(new String[]{}, "BG101");
        } catch (IllegalStateException e) {
            exceptionThrown = true;
        }
        assertEquals(true, exceptionThrown);
    }

    @Test
    public void testSearch_AllowsSearchWhenDataExists() {
        boolean actual = searcher.searchBogie(new String[]{"BG101", "BG205"}, "BG101");
        assertEquals(true, actual);
    }

    @Test
    public void testSearch_BogieFoundAfterValidation() {
        boolean actual = searcher.searchBogie(new String[]{"BG101", "BG205", "BG309"}, "BG205");
        assertEquals(true, actual);
    }

    @Test
    public void testSearch_BogieNotFoundAfterValidation() {
        boolean actual = searcher.searchBogie(new String[]{"BG101", "BG205", "BG309"}, "BG999");
        assertEquals(false, actual);
    }

    @Test
    public void testSearch_SingleElementValidCase() {
        boolean actual = searcher.searchBogie(new String[]{"BG101"}, "BG101");
        assertEquals(true, actual);
    }
}
