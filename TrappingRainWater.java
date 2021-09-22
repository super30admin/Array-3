//https://leetcode.com/problems/trapping-rain-water/
/*
Time: O(n) where n = height.length
Space: O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class TrappingRainWater {
    public int trap(int[] height) {
        int i = 0, j = height.length - 1, maxBarLeft = 0, maxBarRight = 0, totalWater = 0;

        while (i < j) {
            if (height[i] <= height[j]) {
                // water will accumulate on the left, so we would be processing ith pointer

                maxBarLeft = Math.max(maxBarLeft, height[i]);
                totalWater += maxBarLeft - height[i];
                i++;

            } else {
                maxBarRight = Math.max(maxBarRight, height[j]);
                totalWater += maxBarRight - height[j];
                j--;
            }
        }
        return totalWater;

    }

}
