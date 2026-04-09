import java.util.*;
import java.util.stream.*;

public class FilterPassengerBogiesUsingStreams {
    public static void main(String[] args) {

        List<Bogie> bogieList = new ArrayList<>();

        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 56));
        bogieList.add(new Bogie("First Class", 24));

        List<Bogie> filteredList = bogieList.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        System.out.println("Bogies with capacity greater than 60:");
        for (Bogie b : filteredList) {
            b.display();
        }
    }
}