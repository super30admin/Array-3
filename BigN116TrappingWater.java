//Time complexity is O(n)
// Space complexity is O(1)
// This solution is submitted on leetcode

public class BigN116TrappingWater {
	class Solution {
		public int trap(int[] height) {
			// edge case
			if (height == null || height.length == 0)
				return 0;
			int water = 0;
			int leftWall = 0;
			int rightWall = 0;
			int left = 0;
			int right = height.length - 1;
			while (left <= right) {
				if (leftWall < rightWall) {
					// case 1
					if (leftWall < height[left])
						leftWall = height[left];
					else
						water += leftWall - height[left];
					left++;
				} else {
					// case 1:
					if (rightWall < height[right])
						rightWall = height[right];
					else
						water += rightWall - height[right];
					right--;
				}
			}
			return water;
		}
	}
}