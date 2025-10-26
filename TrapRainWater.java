//TC: O(n), SC: O(1)
public class TrapRainWater {

    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = height[0], rightMax = height[right];

        int trap = 0;
        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                trap += Math.max(0, leftMax - height[left]);
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                trap += Math.max(0, rightMax - height[right]);
            }
        }

        return trap;
    }
}
