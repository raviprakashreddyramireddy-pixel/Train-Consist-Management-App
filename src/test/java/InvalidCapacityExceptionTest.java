import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvalidCapacityExceptionTest {

    @Test
    public void testException_ValidCapacityCreation() throws InvalidCapacityException {
        PassengerBogie bogie = new PassengerBogie("Sleeper", 72);
        boolean actual = bogie.getCapacity() > 0;
        assertEquals(true, actual);
    }

    @Test
    public void testException_NegativeCapacityThrowsException() {
        boolean exceptionThrown = false;
        try {
            new PassengerBogie("Sleeper", -10);
        } catch (InvalidCapacityException e) {
            exceptionThrown = true;
        }
        assertEquals(true, exceptionThrown);
    }

    @Test
    public void testException_ZeroCapacityThrowsException() {
        boolean exceptionThrown = false;
        try {
            new PassengerBogie("Sleeper", 0);
        } catch (InvalidCapacityException e) {
            exceptionThrown = true;
        }
        assertEquals(true, exceptionThrown);
    }

    @Test
    public void testException_ExceptionMessageValidation() {
        String msg = "";
        try {
            new PassengerBogie("Sleeper", -5);
        } catch (InvalidCapacityException e) {
            msg = e.getMessage();
        }
        assertEquals("Capacity must be greater than zero", msg);
    }

    @Test
    public void testException_ObjectIntegrityAfterCreation() throws InvalidCapacityException {
        PassengerBogie bogie = new PassengerBogie("AC", 54);
        assertEquals("AC", bogie.getType());
        assertEquals(54, bogie.getCapacity());
    }

    @Test
    public void testException_MultipleValidBogiesCreation() throws InvalidCapacityException {
        new PassengerBogie("General", 90);
        new PassengerBogie("FirstClass", 24);
        assertEquals(true, true);
    }
}
