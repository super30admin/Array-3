// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int hIndex(int[] citations) {
        if(citations.length == 0 || citations == null)
            return 0;

        int n = citations.length;
        int[] bucket = new int[n + 1];

        for(int i=0; i<n; i++){
            if(citations[i] > n)
                bucket[n]++;
            else
                bucket[citations[i]]++;
        }

        int sum = 0;
        for(int i=bucket.length - 1; i>=0; i--){
            sum = sum + bucket[i];
            if(sum >= i)
                return i;

        }
        return 0;
    }
}