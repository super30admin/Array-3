import java.util.ArrayList;
import java.util.List;

// Time Complexity : O(logn) where n = length of citations array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//275. H-Index II (Medium) - https://leetcode.com/problems/h-index-ii/
class Solution {
    public int hIndex(int[] citations) {
    	// Time Complexty : O(n) where n = length of citations array
    	// Space Complexity : O(1)
//        if (citations == null || citations.length == 0) return 0;
//        
//        int n = citations.length;
//        
//        for (int i = 0; i < n; i++) {
//            int diff = n - i;
//            
//            if (diff <= citations[i]) return diff;
//        }
//        
//        return 0;
    	
    	// Time Complexty : O(logn) where n = length of citations array
    	// Space Complexity : O(1)
    	if (citations == null || citations.length == 0) return 0;
        
        int n = citations.length;
        int start = 0, end = n-1;
        
        while (start <= end) {
            int mid = start + (end-start)/2;
            int diff = n-mid;
            if (citations[mid] == diff) {
                return diff;
            } else if (citations[mid] < diff) {
                start = mid+1;
            } else {
                end = mid-1;
            }
        }
        
        return n - start;
    }
}