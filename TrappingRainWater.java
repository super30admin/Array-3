// Time Complexity: O(N)
// Space Complexity: O(1)
class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int waterTrapped = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                // If left is shorter
                if (height[left] >= leftMax) {
                    leftMax = height[left];  // update boundary
                } else {
                    waterTrapped += leftMax - height[left];  // trap water
                }
                left++;
            } else {
                // If right is shorter
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    waterTrapped += rightMax - height[right];
                }
                right--;
            }
        }

        return waterTrapped;
    }
}
