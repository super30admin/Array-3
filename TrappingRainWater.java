//Time Complexity: O(N)
//Space Complexity: O(N)
// https://leetcode.com/problems/trapping-rain-water/

/**
 * Computes left and right max height arrays to determine water trapped at each index.  
 * Iterates through the height array to accumulate trapped water using these precomputed boundaries.  
 * Uses auxiliary arrays to store intermediate maximum values for efficient calculation.  
 */

public class TrappingRainWater {
    public int trap(int[] height) {
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        leftMax[0] = height[0];

        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        rightMax[height.length - 1] = height[height.length - 1];

        for (int i = height.length - 2; i>=0; i--) {
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }

        int water = 0;

        for (int i = 0; i < height.length; i++) {
            water += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return water;
    }
}
