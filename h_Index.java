// Time Complexity : O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
import java.util.*;

class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] helper = new int[n + 1];
        
        for (int i = 0; i < n; i++) {
            if (citations[i] > n) {
                helper[n]++;
            }
            else {
                helper[citations[i]]++;
            }
        }
        
        int papers = 0;
        for (int i = n; i >= 0; i--) {
            papers += helper[i];
            
            if (papers >= i) {
                return i;
            }
        }
        
        return -1;
    }
}