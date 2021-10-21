// Time complexity: O(n)
// Space complexity: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int hIndex(int[] citations) {
        // return 0 if input array is empty or null
        if(citations == null || citations.length == 0) return 0;
        int n = citations.length;
        // initalize a bucket array to perform bucket sort
        int[] bucket = new int[n+1];
        int sum = 0;
        // iterate through citations array
        for(int i = 0; i < n; i++){
            // compare number of citations at i and length of citations array
            if(citations[i] >= n){
                bucket[n]++; // increment value of last index of bucket array
            } else {
                bucket[citations[i]]++; // increment value of index of of bucket array corresponding to the value
            }
        }
        // reverse iterate through bucket array
        for(int i = bucket.length - 1; i >=0; i--){
            // keep updating the sum
            sum += bucket[i];
            // return the index where sum is greater than or eqaul to the index
            if(sum >= i) return i;
        }
        return 0;
    }
}