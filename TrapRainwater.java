// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Approach : We maintain left and right pointers along with left and right walls. We squeeze the left and pointers until they dont cross
// each other. If leftWall is less than rightWall that means we have a guarantee towards right and start calculating the water trapped from
// left, we process from right in case of vice-versa. We can trap the water only if the height is less than the wall, so we do that checks
// and move the wall or update the result.

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int left = 0; //left pointer
        int right = n-1; //right pointer
        int leftWall = 0; //left wall pointer
        int rightWall = 0; //right wall pointer
        int result = 0;

        while(left <= right){ //until left right wont cross each other
            if(leftWall <= rightWall){ //process left
                if(leftWall < height[left]){ //cannot trap water, move wall
                    leftWall = height[left];
                } else{
                    result += leftWall - height[left]; //trap water, update the result
                }
                left++;
            } else{ //process right
                if(rightWall < height[right]){//cannot trap water, move wall
                    rightWall = height[right];
                } else{
                    result += rightWall - height[right];//trap water, update the result
                }
                right--;
            }
        }

        return result;
    }
}