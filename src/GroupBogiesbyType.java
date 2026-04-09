import java.util.*;
import java.util.stream.*;

public class GroupBogiesbyType {
    public static void main(String[] args) {

        List<Bogie> bogieList = new ArrayList<>();

        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 56));
        bogieList.add(new Bogie("First Class", 24));
        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 56));

        Map<String, List<Bogie>> groupedMap =
                bogieList.stream()
                        .collect(Collectors.groupingBy(b -> b.name));

        System.out.println("Grouped Bogies by Type:");

        for (Map.Entry<String, List<Bogie>> entry : groupedMap.entrySet()) {
            System.out.println(entry.getKey() + ":");
            for (Bogie b : entry.getValue()) {
                b.display();
            }
        }
    }
}