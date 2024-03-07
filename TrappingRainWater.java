// https://leetcode.com/problems/trapping-rain-water/description/

// Two pointers
// Time Complexity: O(n)
// Space Complexity: O(n)

// The leftMax array stores the maximum height to the left of each building,
// and the rightMax array stores the maximum height to the right of each building.
// Finally, it calculates the trapped water by taking the minimum of leftMax and
// rightMax for each building and subtracting the height of the building itself.

class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;

        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        // Calculate the max height to the left of each building
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // Calculate the max height to the right of each building
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        // Calculate the trapped water for each building
        int waterTrapped = 0;
        for (int i = 0; i < n; i++) {
            waterTrapped += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return waterTrapped;

    }
}
