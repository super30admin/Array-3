/*
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(n)
* 
* Space Complexity: O(1)
* 
*/
public class TrappingRainWaterSinglePass {
    public int trap(int[] height) {
        int n = height.length;

        int leftWall = 0, rightWall = n - 1, curr;

        int waterTrapped = 0;

        while (leftWall < rightWall) {
            if (height[leftWall] <= height[rightWall]) {
                curr = leftWall;

                while (curr < rightWall && height[leftWall] >= height[curr]) {
                    waterTrapped += (height[leftWall] - height[curr]);
                    curr++;
                }

                leftWall = curr;
            } else {
                curr = rightWall;

                while (curr > leftWall && height[rightWall] >= height[curr]) {
                    waterTrapped += (height[rightWall] - height[curr]);
                    curr--;
                }

                rightWall = curr;
            }
        }

        return waterTrapped;
    }
}
