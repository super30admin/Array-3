// Time Complexity : O(n) --> where n is the length of height array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode (42): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int trap(int[] height) {
        // edge case
        if (height == null || height.length == 0) return 0;
        
        int n = height.length;
        int result = 0;
        int l = 0; int r = n-1;
        int lw = 0; int rw = 0; // these are heights and NOT INDICIES
        
        while (l <= r) {
            if (lw <= rw) { // operate on left hand side of array
                if (lw > height[l]) result += lw - height[l];
                else lw = height[l];
                l++;
            }
            else { // operate on right hand side of array
                if (rw > height[r]) result += rw - height[r];
                else rw = height[r];
                r--;                
            }
        }
        return result;
    }
}