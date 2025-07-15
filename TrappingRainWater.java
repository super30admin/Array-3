// TC: O(n)
// SC: O(1)
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int left = 0;
        int leftWall = 0;
        int right = n - 1;
        int rightWall = 0;
        int result = 0;

        while (left <= right) {

            if (leftWall < rightWall) {
                // rightwall garentees that we can process left
                if (height[left] < leftWall) {
                    // we can only process left if leftWall > left to stop water
                    // add to result
                    result = result - height[left] + leftWall;
                } else {
                    leftWall = height[left];
                }
                left++;
            } else {

                if (height[right] < rightWall) {
                    result = result - height[right] + rightWall;
                } else {
                    rightWall = height[right];
                }
                right--;

            }

        }

        return result;
    }

}