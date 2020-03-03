// Time Complexity : O(n) where n is the length of the citations array
// Space Complexity : O(n) wher n is the length of the citations array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class hIndex_CountingSort {
    public int hIndex(int[] citations) {
        if (citations.length == 0) return 0;
        int n = citations.length;
        int[] counts = new int[n + 1];
        for (int c : citations) {
            if (c >= n) {
                counts[n]++;
            } else {
                counts[c]++;
            }
        }
        int sum = 0;
        for (int i = n; i >= 0; i--) {
            sum += counts[i];
            if (i <= sum) {
                return i;
            }
        }
        return 0;
    }
}