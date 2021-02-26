/*
Time Complexity : O(N)
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

 */
class Solution 
{
    public int trap(int[] height) 
    {
        
        int result = 0;
        
        if( height == null || height.length == 0)
            return result;
        
        int left = 0;
        int right = height.length -1;
        int leftMaxHeight = height[left];
        int rightMaxHeight = height[right];
        
        
        while(left < right)
        {
            if(height[left] <= height[right])
            {
                // water that can be held in that block will depend on the leftMaxHeight
                leftMaxHeight = Math.max(leftMaxHeight, height[left]); 
                result = result + (leftMaxHeight - height[left]);
                left++;
            }
            else
            {
                // water that can be held in that block will depend on the rightMaxHeight
                rightMaxHeight = Math.max(rightMaxHeight, height[right]); 
                result = result + (rightMaxHeight - height[right]);
                right--;
            }
        }
        
        return result;
    }
}