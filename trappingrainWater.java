//------------------------Three pass algo---------------------
// Time Complexity :O(n)
// Space Complexity :constant
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No

class Solution {
    public int trap(int[] height) {
        int maxheight = 0;
        int maxptr = 0;
        int result = 0;
        // finding max height
        for (int i = 0; i < height.length; i++) {
            if (height[i] > maxheight) {
                maxheight = height[i];
                maxptr = i;
            }

        }
        int lw = 0;
        // left to maxheight
        for (int i = 0; i <= maxptr; i++) {
            // if wall has smaller height, we cannot store any water
            if (height[lw] < height[i]) {
                lw = i;
            } else {
                result += height[lw] - height[i];
            }
        }
        // right to maxheight
        int rw = height.length - 1;
        for (int i = rw; i >= maxptr; i--) {
            if (height[rw] < height[i]) {
                rw = i;
            } else {
                result += height[rw] - height[i];
            }
        }
        return result;
    }
}

// -----------------SINGLE PASS ALGO--------------------
// Time Complexity :O(n)
// Space Complexity :constant
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :No
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