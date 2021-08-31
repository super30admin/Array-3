// Time Complexity : O(n), n -> number of citations
// Space Complexity : O(n)
public class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }

        int n = citations.length;
        int[] buckets = new int[n + 1];

        for (int i = 0; i < n; i++) {
            if (citations[i] >= n) {
                buckets[n]++;
            } else {
                buckets[citations[i]]++;
            }
        }

        int papers = 0;
        for (int i = n; i >= 0; i--) {
            papers += buckets[i];

            if (papers >= i) {
                return i;
            }
        }
        return 0;
    }
}