import java.util.Arrays;

public class Problem2 {
    // TC : O(n)
    // SC : O(n)
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) return 0;

        int n = citations.length;
        int[] buckets = new int[n + 1];

        for (int i = 0; i < n; i++) {
            if (citations[i] < n) {
                buckets[citations[i]]++;
            } else {
                buckets[n]++;
            }
        }
        int count = 0;
        for (int i = n; i >= 0; i--) {
            count = count + buckets[i];
            if (count >= i) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Problem2 problem2 = new Problem2();
        System.out.println("result valur " + problem2.hIndex(new int[]{3, 0, 6, 1, 5}));
    }
}
