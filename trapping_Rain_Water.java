class Solution {
    public int trap(int[] height) {
    	//approach: we keep a left wall and right wall while processing elements, left and right pointer will be at left and right ends of the array. If leftwall is higher than right we process the right side and vice versa. 
        if(height == null || height.length == 0)
            return 0;
        int result = 0, n = height.length;
        int leftWall = 0, rightWall = 0, left = 0, right = n-1;
        while(left <= right)
        {
            if(leftWall <= rightWall)
            {
                //we will process the left wall first
                if(leftWall >= height[left] )
                {
                    result += leftWall - height[left];
                }else
                {
                    leftWall = height[left];
                }
                left++;
            }else
            {
                if(rightWall >= height[right])
                {
                    result += rightWall - height[right];
                }else
                {
                    rightWall = height[right];
                }
                right--;
            }
        }
        return result;
    }
}
//Time Complexity : O(n)
//Space Complexity : O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :

