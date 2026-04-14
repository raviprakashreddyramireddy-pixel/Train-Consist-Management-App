import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CargoAssignerTest {

    private CargoAssigner assigner;

    @BeforeEach
    public void setUp() {
        assigner = new CargoAssigner();
    }

    @Test
    public void testCargo_SafeAssignment() {
        GoodsBogie bogie = new GoodsBogie("Cylindrical", "");
        boolean result = assigner.assignCargo(bogie, "Petroleum");
        assertEquals(true, result);
    }

    @Test
    public void testCargo_UnsafeAssignmentHandled() {
        GoodsBogie bogie = new GoodsBogie("Rectangular", "");
        boolean result = assigner.assignCargo(bogie, "Petroleum");
        assertEquals(false, result);
    }

    @Test
    public void testCargo_CargoNotAssignedAfterFailure() {
        GoodsBogie bogie = new GoodsBogie("Rectangular", "");
        boolean result = assigner.assignCargo(bogie, "Petroleum");
        assertEquals(false, result);
    }

    @Test
    public void testCargo_ProgramContinuesAfterException() {
        GoodsBogie bogie1 = new GoodsBogie("Rectangular", "");
        assigner.assignCargo(bogie1, "Petroleum");
        GoodsBogie bogie2 = new GoodsBogie("Cylindrical", "");
        boolean result2 = assigner.assignCargo(bogie2, "Petroleum");
        assertEquals(true, result2);
    }

    @Test
    public void testCargo_FinallyBlockExecution() {
        GoodsBogie bogie = new GoodsBogie("Rectangular", "");
        assigner.assignCargo(bogie, "Petroleum");
        assertEquals(true, assigner.getFinallyExecuted());
    }
}
