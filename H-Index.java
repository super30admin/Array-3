// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] dp = new int[n+1];
        
        
        for(int citation: citations){
            if(citation >= n) dp[n]++;
            else dp[citation]++;
            
        }
        int rSum = 0;
        for(int i = n ; i >= 0 ; i--){
            rSum += dp[i];
            if(rSum >= i) return i;
        }
        return -1;
        
    }
}
