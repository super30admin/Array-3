/**
Time Complexity : O(N)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/
class Solution 
{
    public int trap(int[] height)
    {

        if(height == null || height.length == 0)
            return 0;

        int left = 0;
        int right = height.length -1;

        int leftMax = 0;
        int rightMax = 0;

        int result = 0;

        while(left <= right)
        {
            if(leftMax <= rightMax)
            {
                if(height[left] < leftMax)
                    result = result + (1 * (leftMax - height[left]));
                else
                    leftMax = height[left];
                
                left++;
            }
            else
            {
                if(height[right] < rightMax)
                    result = result + (1 * (rightMax - height[right]));
                else
                    rightMax = height[right];
                
                right--;
            }

        }

        return result;
    }
}