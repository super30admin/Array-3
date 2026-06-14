// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
I maintain left pointer at index 0 and right pointer at index height.Length - 1. Initially, leftWall and rightWall both are 0. I start traversal while left < right, I keep updating leftWall
and rightWall values by keeping track of max values found for height[left] and height[right]. If leftWall < rightWall i.e a dam exists on the right side, I calculate the water trapped as
leftWall - height[left] (Water can only be trapped on left side as dam is present on the right). Similarly if leftWall > rightWall a dam exists on the left side, I calculate water trapped as
rightWall - height[right]. Water side I trapped water on I move the pointer corresponding to it. At the end I return the result as the total water trapped.
*/

public class Solution {
    public int Trap(int[] height) {
        int result = 0;
        
        int left = 0;
        int leftWall = 0;
        int right = height.Length - 1;
        int rightWall = 0;

        while(left<right)
        {
            leftWall = Math.Max(leftWall, height[left]);
            rightWall = Math.Max(rightWall, height[right]);

            if(leftWall < rightWall)
            {
                result += (leftWall - height[left]);
                left++;
            }

            else
            {
                result += (rightWall - height[right]);
                right--;
            }
        }

        return result;
    }
}