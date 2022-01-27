// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// We solve this by taking two pointers l and r
// We also take lw and rw
// we move from left to right
// we compare lw and rw and lw and height[l] and based on the result we compute the answer

class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        int lw = 0, rw = 0;
        int l = 0, r = height.length - 1;
        int result = 0;
        while (l <= r) {
            if (lw <= rw) {
                if (lw > height[l]) {
                    result = result + lw - height[l];
                } else {
                    lw = height[l];
                }
                l++;
            } else {
                if (rw > height[r]) {
                    result = result + rw - height[r];
                } else {
                    rw = height[r];
                }
                r--;
            }
        }
        return result;
    }
}