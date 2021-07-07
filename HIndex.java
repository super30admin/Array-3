// Time Complexity : O(n), n - > length of citation array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach:
// The concept is similar to the sorted H-index problem. The additional step in this case is to sort the data efficiently.
// Bucket sort can be used for an efficient sort. Total no. of buckets will be one larger than the citation array. We will include/ replace the number of citations as the max length of citation array wherever it is more than the length.

class Solution {
    public int hIndex(int[] citations) {
        // edge case
        if(citations == null || citations.length == 0)
            return 0;
        
        int n = citations.length;
        
        // bucket sort
        int[] bucket = new int[n+1];
        for(int i = 0; i < n; i++) {
            if(citations[i] >= n)
                bucket[n]++;
            else
                bucket[citations[i]]++;
        }
        
        int citation = 0;
        
        // finding h-index in sorted array
        for(int i = n; i >= 0; i--) {
            citation += bucket[i];
            if(citation >= i)
                return i;
        }
        return 0;
    }
}
