import java.util.Arrays;

public class HIndex {
    public int hIndex(int[] citations) {
        return hIndexWithoutSort(citations);
    }
    // TC: O(N) where N is length of array
    // SC: O(N + 1) where N is length of array
    private int hIndexWithoutSort(int[] citations) {
        int n = citations.length;
        int[] buckets = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int cit = citations[i];
            if (cit >= n) {
                buckets[n]++;
            } else {
                buckets[cit]++;
            }
        }
        int sum = 0;
        for (int i = n; i >= 0; i--) {
            sum += buckets[i];
            if (sum >= i) {
                return i;
            }
        }
        return 0;
    }

    // TC: O(N log N) where N is length of array
    // SC: O(1)
    private int hIndexUsingSort(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n - i) {
                return n - i;
            }
        }
        return 0;
    }
}
