// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : YES

class TrappingRainWater {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int left_max = 0, right_max = 0;
        int result = 0;

        while (l < r) {
            if (height[l] < height[r]) {
                if (height[l] >= left_max) left_max = height[l];
                else result += left_max - height[l];
                l++;
            } else {
                if (height[r] >= right_max) right_max = height[r];
                else result += right_max - height[r];
                r--;
            }
        }
        return result;
    }
}