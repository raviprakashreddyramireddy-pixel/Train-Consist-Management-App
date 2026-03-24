import java.util.LinkedHashSet;
import java.util.Set;

public class PreserveInsertionOrderofBogies {

    public static void main(String[] args) {
        Set<String> trainFormation = new LinkedHashSet<>();

        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");

        boolean isAdded = trainFormation.add("Sleeper");
        if (!isAdded) {
            System.out.println("Duplicate bogie 'Sleeper' ignored.");
        }

        System.out.println("\nFinal Train Formation (in insertion order):");
        for (String bogie : trainFormation) {
            System.out.println(bogie);
        }
    }
}