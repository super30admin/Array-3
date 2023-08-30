// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * 1. Sort the given array using bucket sort.
 * 2. Iterate from last index in the buckets array and keep track of number of papers.
 * 3. if number of papers >= index, return index.
 */

class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] buckets = new int[n+1];

        for(int cite : citations){
            if(cite >= n){
                buckets[n]++;
            }else {
                buckets[cite]++;
            }
        }
        
        int papers = 0;
        for(int i=n; i>=0; i--){
            papers += buckets[i];
            if(papers >= i){
                return i;
            }
        }

        return 0;
    }
}