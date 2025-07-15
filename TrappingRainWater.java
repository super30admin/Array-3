// Time complexity: O(n) where n is the length of the height array
// Space complexity: O(1) for using constant space

// LeetCode Problem: https://leetcode.com/problems/trapping-rain-water/

// Intuition: The problem can be solved using a two-pointer approach. 
// We maintain two pointers, left and right, which start at the beginning and end of the height array, respectively.
// We also maintain two variables, leftWallHeight and rightWallHeight, to keep track of the maximum heights encountered so far from both sides.
// At each step, we compare the heights at the left and right pointers.
// If the height at the left pointer is less than or equal to the height at the right pointer, we can calculate the trapped water at the left pointer.
// If the height at the left pointer is greater than or equal to the height at the right pointer, we can calculate the trapped water at the right pointer.
// We continue this process until the left pointer exceeds the right pointer, accumulating the trapped water in the trap variable.

public class TrappingRainWater {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1, leftWallHeight = 0, rightWallHeight = 0, trap = 0;

        while (left <= right) {
            if (leftWallHeight < rightWallHeight) {
                if (leftWallHeight < height[left])
                    leftWallHeight = height[left];
                else // water can be trapped
                    trap += leftWallHeight - height[left];
                left++;
            } else {
                if (rightWallHeight < height[right])
                    rightWallHeight = height[right];
                else // water can be trapped
                    trap += rightWallHeight - height[right];
                right--;
            }
        }
        return trap;
    }
}
