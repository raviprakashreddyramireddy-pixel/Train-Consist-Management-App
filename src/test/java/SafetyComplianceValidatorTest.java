import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SafetyComplianceValidatorTest {

    private SafetyComplianceValidator validator;

    @BeforeEach
    public void setUp() {
        validator = new SafetyComplianceValidator();
    }

    @Test
    public void testSafety_AllBogiesValid() {
        GoodsBogie b1 = new GoodsBogie("Cylindrical", "Petroleum");
        GoodsBogie b2 = new GoodsBogie("Cylindrical", "Petroleum");
        boolean actual = validator.validateTrainSafety(Arrays.asList(b1, b2));
        assertEquals(true, actual);
    }

    @Test
    public void testSafety_CylindricalWithInvalidCargo() {
        GoodsBogie b1 = new GoodsBogie("Cylindrical", "Coal");
        boolean actual = validator.validateTrainSafety(Arrays.asList(b1));
        assertEquals(false, actual);
    }

    @Test
    public void testSafety_NonCylindricalBogiesAllowed() {
        GoodsBogie b1 = new GoodsBogie("Open", "Coal");
        GoodsBogie b2 = new GoodsBogie("Box", "Grain");
        boolean actual = validator.validateTrainSafety(Arrays.asList(b1, b2));
        assertEquals(true, actual);
    }

    @Test
    public void testSafety_MixedBogiesWithViolation() {
        GoodsBogie b1 = new GoodsBogie("Box", "Grain");
        GoodsBogie b2 = new GoodsBogie("Cylindrical", "Chemicals");
        boolean actual = validator.validateTrainSafety(Arrays.asList(b1, b2));
        assertEquals(false, actual);
    }

    @Test
    public void testSafety_EmptyBogieList() {
        boolean actual = validator.validateTrainSafety(Collections.emptyList());
        assertEquals(true, actual);
    }
}
