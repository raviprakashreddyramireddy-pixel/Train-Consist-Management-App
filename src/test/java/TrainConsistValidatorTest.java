import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrainConsistValidatorTest {

    private TrainConsistValidator validator;

    @BeforeEach
    public void setUp() {
        validator = new TrainConsistValidator();
    }

    @Test
    public void testValidTrainID() {
        boolean actual = validator.validateTrainID("TRN-1234");
        assertEquals(true, actual);
    }

    @Test
    public void testInvalidTrainID() {
        boolean actual = validator.validateTrainID("TRAIN12");
        assertEquals(false, actual);
    }

    @Test
    public void testValidCargoCode() {
        boolean actual = validator.validateCargoCode("PET-AB");
        assertEquals(true, actual);
    }

    @Test
    public void testInvalidCargoCode() {
        boolean actual = validator.validateCargoCode("PET-ab");
        assertEquals(false, actual);
    }
}
