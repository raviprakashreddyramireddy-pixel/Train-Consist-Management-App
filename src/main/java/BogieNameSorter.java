import java.util.Arrays;

public class BogieNameSorter {
    public String[] sortNames(String[] names) {
        if (names == null) {
            return null;
        }
        String[] sorted = new String[names.length];
        System.arraycopy(names, 0, sorted, 0, names.length);
        Arrays.sort(sorted);
        return sorted;
    }
}
