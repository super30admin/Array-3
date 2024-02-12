// Time complexity : O(n)
// Space complexity : O(n)
public class HIndex {
    public static void main(String[] args) {
        int[] citations = { 3, 0, 6, 1, 5 };
        int hIndex = hIndex(citations);
        System.out.println(hIndex);
    }

    private static int hIndex(int[] citations) {
        if (citations == null || citations.length == 0)
            return 0;
        int n = citations.length;
        int[] buckets = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n) {
                buckets[n]++;
            } else {
                buckets[citations[i]]++;
            }
        }
        int sum = 0;
        for (int i = n; i >= 0; i--) {
            sum += buckets[i];
            if (sum >= i)
                return i;
        }
        return 0;
    }
}
