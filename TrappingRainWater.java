// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class TrappingRainWater {
        public int trap(int[] height) {

            if (height == null || height.length == 0) {
                return 0;
            }

            int ans = 0;

            int left = 0;
            int right = height.length - 1;

            int leftmax = 0;
            int rightmax = 0;

            while (left < right) {
                if (height[left] < height[right]) {
                    if (height[left] > leftmax) {
                        leftmax = height[left];
                    } else {
                        ans += leftmax - height[left];
                    }

                    left++;
                } else {
                    if (height[right] > rightmax) {
                        rightmax = height[right];
                    } else {
                        ans += rightmax - height[right];
                    }

                    right--;
                }
            }

            return ans;
        }
}
