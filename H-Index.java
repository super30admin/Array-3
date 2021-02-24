// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public int hIndex(int[] citations) {
        //edge
        if(citations == null) return 0;
        int n = citations.length;
        //create a new array with n+1 buckets
        int [] buckets = new int[n+1];
        //start a for loop going through citations
        for(int i = 0; i < n; i++){
            //if the citaion is greater than length lump if with the last bucket
            if(citations[i] > n){
                buckets[n]++;
            }
            else{
                buckets[citations[i]]++;
            }
        }
        int sum = 0;
        //now go through the buckets backwards and find the breach
        for(int i = n; i >= 0; i--){
            sum += buckets[i];
            if(sum >= i){
                return i;
            }
        }
        return 0;
    }
}