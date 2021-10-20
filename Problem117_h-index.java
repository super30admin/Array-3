// Time Complexity: O(n)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public int hIndex(int[] citations) {
        
        int n = citations.length;
        int count[] = new int[n + 1];
        for(int i = 0; i < n; i++) {
            if(citations[i] >= n) {
                count[n]++;
            } else {
                count[citations[i]]++;
            }
        }
        int sum = 0;
        for(int i = count.length - 1; i >= 0; i--) {
            sum += count[i];
            if(i <= sum)
                return i;
        }
        return 0;
    }
}