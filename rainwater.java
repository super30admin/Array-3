// Time Complexity : 0(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int rw = 0;
        int l = 0;
        int lw = 0;
        int r = height.length - 1; // end of array
        int sum = 0;
        while (l <= r) { // to make sure we iterate over all and this being false means there is overlap
            if (lw <= rw) { // left wall <= right wall
                if (lw >= height[l]) {
                    sum += lw - height[l]; // whatever water that can be contained
                } else {
                    lw = height[l]; // move left wall to left pointer
                }
                l++; // increment
            } else {
                if (rw >= height[r]) {
                    sum += rw - height[r]; 
                } else {
                    rw = height[r];
                }
                r--;
            }
        }

        return sum;
    }
}