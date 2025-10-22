// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//We use bucket sort appraoch and sort only the elements uptil number of papaers
//The papers having citations greater than total number of papers will be accumulated in the nth index
//we fill up the bucket in step 1 and step 2 we calculate the sum ,We go backward from n to 0, and the first index where cumulative count sum ≥ i, that's the H-index.
class Solution {
    public int hIndex(int[] citations) {
        int  n = citations.length;
        int[] bucket = new int[n+1];
        //fill the buckets
        for(int citation: citations) {
            if(citation > n) {
                bucket[n]++;
            } else {
                bucket[citation]++;
            }
        }
        int sum = 0;
        for(int i = n; i > 0; i--) {
            sum += bucket[i];
            if(sum >= i) {
                return i;
            }
        }
        return 0;
        
    }
}
