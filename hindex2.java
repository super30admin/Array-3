// Time Complexity :  0(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No



class Solution {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        int n = citations.length;
        int[] result = new int[n + 1]; // another array with citations count
        for (int i = 0; i < n; i++) { // inserting values into the citation result array
            int index = citations[i];
            if (index > n) { // more than the index so increment the last element
                result[n]++;
            } else {
                result[index]++;
            }
        }
        int sum = 0;
        for (int i = n; i >= 0; i--) {
            sum = sum + result[i]; // keep adding the counts as we move left
            if (sum >= i) {
                return i;
            }
        }
        return 0;
    }
}