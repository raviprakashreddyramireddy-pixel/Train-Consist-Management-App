import java.util.Arrays;

public class BinarySearchBogie {

    public boolean isSorted(String[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    public boolean searchBogie(String[] bogieIds, String targetId) {
        if (bogieIds == null || bogieIds.length == 0 || targetId == null) {
            return false;
        }
        if (!isSorted(bogieIds)) {
            Arrays.sort(bogieIds);
        }

        int low = 0;
        int high = bogieIds.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = targetId.compareTo(bogieIds[mid]);

            if (comparison == 0) {
                return true;
            } else if (comparison < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
