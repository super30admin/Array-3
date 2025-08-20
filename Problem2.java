// Problem2 H-Index (https://leetcode.com/problems/h-index/)


// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// we store the number of citations if greater than n in bucket of n else in bucket of
// citaions paper
// then whereever the sum is greater than or equal to i that is the answer.

class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length ==0) return 0;
        int n = citations.length;
        int[] buckets = new int[n+1];
        for(int el: citations){
            if(el>=n){
                buckets[n]++;
            }
            else buckets[el]++;
        }
        int sum=0;
        for(int i=n;i>=0;i--){
            sum+=buckets[i];
            if(sum>=i) return i;
        }
        return 1818;
    }
}