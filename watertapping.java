// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0; // Check for null or empty array
        int n = height.length;
        int result = 0;
        int l = 0, r = n - 1; 
        int lw = 0, rw = 0;

        while(l <= r) {
            if(lw <= rw) {
                if(lw > height[l]) {
                    result += lw - height[l];
                } else {
                    lw = height[l];
                }
                l++;
            } else {
                if(rw > height[r]) {
                    result += rw - height[r];
                } else {
                    rw = height[r];
                }
                r--;
            }
        }
        return result;
    }
}
