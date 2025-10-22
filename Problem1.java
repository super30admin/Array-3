/*
42. Trapping Rain Water
Ran on leetcode: Yes
TC: O(n)
SC: O(1)
Compare heights of left wall and right wall, if right wall is bigger solve the left side and update the result and vice versa
*/
class Solution {
    public int trap(int[] height) {
        int length = height.length;
        int leftWall = 0;
        int rightWall = length - 1;
        int leftHeight = 0;
        int rightHeight = length - 1;

        int result = 0;

        while(leftHeight <= rightHeight){
            if(height[leftWall] < height[rightWall]){ // right wall is the limiting factor, solve left
                if(height[leftHeight] < height[leftWall]){ // height is decreasing we can trap water
                    result += height[leftWall] - height[leftHeight];
                } else { // height is increasing we cant trap water
                    leftWall = leftHeight;
                }
                leftHeight++;
            } else { // left wall is the limiting factor, solve right
                if(height[rightHeight] < height[rightWall]){ // height is decreasing we can trap water
                    result += height[rightWall] - height[rightHeight];
                } else { // height is increasing we cant trap water
                    rightWall = rightHeight;
                }
                rightHeight--;
            }
        }

        return result;
    }
}