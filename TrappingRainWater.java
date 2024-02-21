/*
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(2n)
* 
* Space Complexity: O(1)
* 
*/


public class TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length;

        int maxIdx = -1;

        for (int index = 0; index < n; index++) {
            if (maxIdx == -1 || height[index] > height[maxIdx]) {
                maxIdx = index;
            }
        }

        int leftWall = 0, rightWall, curr = 0;

        int waterTrapped = 0;

        while (curr < maxIdx) {
            if (height[leftWall] < height[curr]) {
                leftWall = curr;
            } else {
                waterTrapped += (height[leftWall] - height[curr]);
            }

            curr++;
        }

        rightWall = n - 1;
        curr = n - 1;

        while (curr > maxIdx) {
            if (height[rightWall] < height[curr]) {
                rightWall = curr;
            } else {
                waterTrapped += (height[rightWall] - height[curr]);
            }

            curr--;
        }

        return waterTrapped;
    }
}