// Time Complexity: O(N)
// Space Complexity: O(N)
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] buckets = new int[n + 1];

        // Fill the buckets
        for (int el : citations) {
            if (el >= n) {
                buckets[n]++;
            } else {
                buckets[el]++;
            }
        }

        // Traverse from the end to find the h-index
        int sum = 0;
        for (int i = n; i >= 0; i--) {
            sum += buckets[i];
            if (sum >= i) return i;
        }

        return 0;
    }
}
