// Time Complexity : O(n) --> where n is the length of input citation array
// Space Complexity : O(n)
// Did this code successfully run on Leetcode (274): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        // edge case
        if (citations == null || n == 0) return 0;
        
        int bucket[] = new int[n+1];
        for (int i = 0; i < n; i++) {
            bucket[Math.min(citations[i], n)]++;
        }
        
        int sum = 0;
        for (int i = n; i >= 0; i--) {
            sum += bucket[i]; 
            if (sum >= i) return i;
        }
        return 0;
    }
}