public class BubbleSortBogies {
    public int[] sortCapacities(int[] capacities) {
        if (capacities == null) {
            return null;
        }
        int[] sorted = new int[capacities.length];
        System.arraycopy(capacities, 0, sorted, 0, capacities.length);
        
        int n = sorted.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (sorted[j] > sorted[j + 1]) {
                    int temp = sorted[j];
                    sorted[j] = sorted[j + 1];
                    sorted[j + 1] = temp;
                }
            }
        }
        return sorted;
    }
}
