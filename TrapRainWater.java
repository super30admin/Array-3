//Time Complexity: O(n)
//Space Complexity: O(1)
public class TrapRainWater {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        int result = 0;
        while ( left < right ) {
            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                result = result + leftMax - height[left];
            }
            else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                result = result+ rightMax - height[right];
            }
        }
        return result;
    }
}
