//  Time Complexity: O(n)
//  Space Copmlexity: O(n)

public class H_Index {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] buckets = new int[n+1];

        for (int i = 0; i < citations.length; ++i) {
            if (citations[i] < n) {
                buckets[citations[i]]++;
            }
            else {
                buckets[n]++;
            }
        }

        int sum = 0;
        for (int i = n; i >= 0; --i) {
            sum += buckets[i];
            if (sum >= i) {
                return i;
            }
        }

        return 0;
    }
}
