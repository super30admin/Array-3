//  Time Complexity: O(n)
//  Space Complexity: O(1)

public class TrappingRainWater {
    public int trap(int[] height) {
        int leftWall = 0;
        int rightWall = 0;

        int l = 0;
        int r = height.length - 1;

        int result = 0;

        while (l < r) {
            leftWall = Math.max(leftWall, height[l]);
            rightWall = Math.max(rightWall, height[r]);

            if (leftWall <= rightWall) {
                result += leftWall - height[l];
                l++;
            }
            else {
                result += rightWall - height[r];
                r--;
            }
        }

        return result;
    }
}
