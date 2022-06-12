// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int hIndex(int[] citations) {
        
        int n = citations.length;
        int[] hIndex = new int[n + 1];
        
        for(int i = 0; i < n; i++) {
            if(citations[i] > n) {
                hIndex[n]++;
            } else {
                hIndex[citations[i]]++;
            }
        }
        
        int rSum = 0;
        
        for(int i = n; i >= 0; i--) {
            rSum += hIndex[i];
            
            if(rSum >= i) {
                return i;
            }
        }
        
        return -1;
    }
}