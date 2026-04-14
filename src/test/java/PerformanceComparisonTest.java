import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PerformanceComparisonTest {

    private PerformanceComparison performance;
    private List<PassengerBogie> testData;

    @BeforeEach
    public void setUp() throws InvalidCapacityException {
        performance = new PerformanceComparison();
        testData = new ArrayList<>();
        testData.add(new PassengerBogie("Sleeper", 72));
        testData.add(new PassengerBogie("AC", 54));
        testData.add(new PassengerBogie("General", 90));
        testData.add(new PassengerBogie("FirstClass", 24));
    }

    @Test
    public void testLoopFilteringLogic() {
        List<PassengerBogie> result = performance.filterUsingLoop(testData);
        assertEquals(2, result.size());
    }

    @Test
    public void testStreamFilteringLogic() {
        List<PassengerBogie> result = performance.filterUsingStream(testData);
        assertEquals(2, result.size());
    }

    @Test
    public void testLoopAndStreamResultsMatch() {
        List<PassengerBogie> loopResult = performance.filterUsingLoop(testData);
        List<PassengerBogie> streamResult = performance.filterUsingStream(testData);
        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    public void testExecutionTimeMeasurement() {
        long time = performance.measureExecutionTime(() -> performance.filterUsingStream(testData));
        boolean actual = time > 0;
        assertEquals(true, actual);
    }

    @Test
    public void testLargeDatasetProcessing() throws InvalidCapacityException {
        List<PassengerBogie> largeData = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            largeData.add(new PassengerBogie("Sleeper", 72));
        }
        List<PassengerBogie> result = performance.filterUsingStream(largeData);
        assertEquals(10000, result.size());
    }
}
