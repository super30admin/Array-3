import java.util.ArrayList;
import java.util.List;

// Time Complexity : O(n) where n = length of citations array
// Space Complexity : O(n) where n = length of citations array
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//274. H-Index (Medium) - https://leetcode.com/problems/h-index/
class Solution {
    public int hIndex(int[] citations) {
//        if (citations == null || citations.length == 0) return 0;
//        
//        int n = citations.length;
//        
//        Arrays.sort(citations); // O(nlogn) where n = length of citations array
//        
//        for (int i = 0; i < n; i++) { // O(n)
//            int diff = n - i;
//            if (diff <= citations[i]) {
//                return diff;
//            }
//        }
//        
//        return 0;
    	
    	if (citations == null || citations.length == 0) return 0;
        
        int n = citations.length;
        int[] buckets = new int[n+1];
        
        for (int i = 0; i < n; i++) { // O(n)
            if (citations[i] >= n) {
                buckets[n]++;
            } else {
                buckets[citations[i]]++;
            }
        }
        
        int sum = 0;
        
        for (int i = n; i >= 0; i--) { // O(n)
            sum += buckets[i];
            
            if (sum >= i) return i;
        }
        
        return 0;
    }
}