import java.util.HashMap;
import java.util.Map;

public class MapBogietoCapacity {

    public static void main(String[] args) {
        HashMap<String, Integer> bogieCapacityMap = new HashMap<>();

        bogieCapacityMap.put("Sleeper", 72);
        bogieCapacityMap.put("AC Chair", 60);
        bogieCapacityMap.put("First Class", 50);

        System.out.println("Bogie Capacity Details:");
        for (Map.Entry<String, Integer> entry : bogieCapacityMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue() + " seats");
        }
    }
}