// Time Complexity : O(n), n -> Number of elevations
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem1;

public class TrappingRainWater {
	public int trap(int[] height) {
		if (height == null || height.length < 3) {
			return 0;
		}

		int leftWall = 0;
		int rightWall = 0;
		int left = 0;
		int right = height.length - 1;
		int waterTrapped = 0;

		while (left <= right) {
			if (leftWall <= rightWall) {
				if (height[left] < leftWall) {
					// Trap Water
					waterTrapped += leftWall - height[left];
				} else {
					// New Wall on the left
					leftWall = height[left];
				}
				left++;
			} else {
				if (height[right] < rightWall) {
					// Trap Water
					waterTrapped += rightWall - height[right];
				} else {
					// New Wall on the right
					rightWall = height[right];
				}
				right--;
			}
		}
		return waterTrapped;
	}

	public static void main(String[] args) {
		TrappingRainWater obj = new TrappingRainWater();
		int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println("Maximum amount of water that can be trapped: " + obj.trap(height));
	}

}
