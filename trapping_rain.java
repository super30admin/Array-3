// Time Complexity :O(n)
// Space Complexity :constant
// Did this code successfully run on Leetcode :yes



class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int rw = 0;
        int lw = 0;
        int result = 0;
        // finding max height
        while (l <= r) {
            // if left wall is smaller, calculate left's water
            if (lw <= rw) {
                // left water
                if (lw < height[l]) {
                    lw = height[l];
                } else {
                    result += lw - height[l];
                }
                l++;
            } else {// calculate water from right
                if (rw < height[r]) {
                    rw = height[r];
                } else {
                    result += rw - height[r];
                }
                r--;
            }
        }

        return result;
    }
}