// # Time Complexity:  O(n) where n is the length
// #  Space Complexity:  O(1)
// #  Did this code successfully run on Leetcode : Yes
// #  Any problem you faced while coding this : No
class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0) {
            return 0;
        }
        
        
        int result = 0;

        int lw = 0;
        int rw = 0;
        int l = 0;
        int r = height.length -1;

        while(l <= r) {
            if(lw <= rw) {
                //left  wall is smaller and right wall is greater
                if(lw >= height[l]) {
                    result = result + (lw - height[l]);
                } else {
                    lw = height[l];
                }
                l++;
            }
            else { 
                //right wall is smaller and left wall is greater
                if(rw >= height[r]) {
                    result = result + (rw - height[r]);
                }
                else {
                    rw = height[r];
                }
                r--;

            }
        }

        return result; 

    }
}
