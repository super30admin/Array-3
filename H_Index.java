// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

// Create a bucket array and input number of papers for citation value as index
// Iterate through the bucket array starting from end and count sum
// When sum is greater or equal to index(citation value) return index

class Solution {
    public int hIndex(int[] citations) {
        
        if(citations == null || citations.length == 0) {
            return 0;
        }
        
        int n = citations.length;
        int[] bucket = new int[n + 1];
        
        for(int i = 0; i < n; i++) {
            if(citations[i] >= n) {
                bucket[n]++;
            }
            else
            {
                bucket[citations[i]]++;
            }
        }
        
        int sum = 0;
        
        for(int i = n; i >= 0; i--) {
            sum += bucket[i];
            if(sum >= i) {
                return i;
            }
        }
        return 0;
    }
}