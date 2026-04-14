import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PerformanceComparison {

    public List<PassengerBogie> filterUsingLoop(List<PassengerBogie> bogies) {
        List<PassengerBogie> result = new ArrayList<>();
        for (PassengerBogie b : bogies) {
            if (b.getCapacity() > 60) {
                result.add(b);
            }
        }
        return result;
    }

    public List<PassengerBogie> filterUsingStream(List<PassengerBogie> bogies) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
    }

    public long measureExecutionTime(Runnable logic) {
        long start = System.nanoTime();
        logic.run();
        long end = System.nanoTime();
        return end - start;
    }
}
