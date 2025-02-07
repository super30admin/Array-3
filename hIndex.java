// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes

class Solution {

    public int hIndex(int[] citations) {
        int n = citations.length;

        int[] buckets = new int[n + 1];

        for (int i = 0; i < n; i++) {
            if (citations[i] >= n) {
                buckets[n]++;
            } else {
                buckets[citations[i]]++;
            }
        }

        int res = 0;
        for (int i = n; i >= 0; i--) {
            res += buckets[i];
            if (res >= i)
                return i;
        }
        return res;
    }

}