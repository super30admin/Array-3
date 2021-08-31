//T.C: O(N); N is no. of Elevation
//S.C: O(1)
class Solution {
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
                    // trap Water
                    waterTrapped += leftWall - height[left];
                } else {
                    // new wall on the left
                    leftWall = height[left];
                }
                left++;
            } else {
                if (height[right] < rightWall) {
                    // trap Water
                    waterTrapped += rightWall - height[right];
                } else {
                    // new wall on the right
                    rightWall = height[right];
                }
                right--;
            }
        }
        return waterTrapped;
    }
}