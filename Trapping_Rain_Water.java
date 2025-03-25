// Time complexity:- O(n)
// Space complexity:- O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach 
/**
 * Approach:
 * This problem is about calculating the amount of trapped rainwater between bars of varying heights.
 * I used a two-pointer approach: the first pointer from left to right up to the maximum height index,
 * and the second pointer from right to left, both checking for trapped water as I track the walls on both sides.
 * First, I loop through the array to find the maximum height and its index. Then, I make two pointer: one from left to 
 * right to calculate trapped water and one from right to left to calculate the remaining trapped water.
 * In both pointer, I use a wall tracker for both left and right sides and calculate trapped water by comparing the current height with the wall height.
 */

class Solution {
    public int trap(int[] height) {
        int n = height.length;

        // Variables to track the index and value of the maximum height
        int maxIdx = -1;
        int max = 0; // strore the max height

        // Loop through the array to find the maximum height and its index
        for(int i = 0; i < n; i++) {
            if(height[i] > max) {
                max = height[i];
                maxIdx = i; // Store the index of the maximum height
            }
        }

        // Run from left to right up to the maximum index to calculate trapped water
        int result = 0; // This will store the total amount of trapped water
        int left = 0;  // Left index for the left-to-right pass
        int leftWall = 0; // Left wall height tracker

        while(left < maxIdx) {
            // If the current height is lower than the left wall, calculate trapped water
            if(leftWall > height[left]) {
                result = result + leftWall - height[left];
            } else {
                // Update the left wall height to the current height if it is higher
                leftWall = height[left];
            }
            left++;
        }

        // Now run from right to left starting from the last index to the maximum index
        int right = n - 1;
        int rightWall = 0;
        while(right > maxIdx) {
            // If the current height is lower than the right wall, calculate trapped water
            if(rightWall > height[right]) {
                result = result + rightWall - height[right];
            }else {
                // Update the right wall height to the current height if it is higher
                rightWall = height[right];
            }
            right--;
        }
        return result;
    }
}
