package Array3;

/*S30 FAANG Problem #118 {Hard } - https://www.youtube.com/watch?v=hP9SdQV2HR0
    Provided n non-negative integers representing an elevation map where the width of each bar is 1, calculate how much water it is able to trap after raining.


    The elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. 

    Example:

    Input: [0,1,0,2,1,0,1,3,2,1,2,1]

    Output: 6
    Source Link: https://leetcode.com/problems/trapping-rain-water/
-------------------------------------------------------------------------------------------------------
Time complexity : O(N) 
space complexity: O(1) 
Approach:
Did this code run successfully in leet code : yes
problems faces : no*/

public class TrappingWater {

    public int trap(int[] height) {

        if (height == null || height.length < 2)
            return 0;

        int result = 0;
        int n = height.length;

        int left = 0;
        int right = n - 1; // pointers
        int leftWall = 0; //height of wall not index
        int rightWall = 0; //height of wall not index

        while (left <= right) {

            if (leftWall <= rightWall) // left side to process
            {
                if (height[left] < leftWall) {
                    result = result + (leftWall - height[left]) * 1;

                } else {
                    leftWall = height[left];
                }
                left++;
            } else // right side to process
            {
                if (height[right] < rightWall) {
                    result = result + (rightWall - height[right]) * 1;

                } else {
                    rightWall = height[right];
                }
                right--;
            }

        }
        return result;
    }

}
