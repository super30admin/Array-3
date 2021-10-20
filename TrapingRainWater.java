// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : 

// Your code here along with comments explaining your approach




class Solution {
    public int trap(int[] height) {
        
        int n = height.length;
        int leftWall = 0;
        int rightWall =0;
        
        int l = 0;//height[0]; 
        int r = n-1;//height[n-1];
        int result =0;
        while(l<=r)
        {
            if(leftWall <= rightWall) // process left side 
            {
                if(leftWall >height[l])
                {
                    result +=  leftWall -height[l] ;
                    
                }
                else
                    leftWall = height[l];
                l++;
            }
            else // process right side
            {
               if(rightWall >height[r])
                {
                    result += rightWall - height[r]  ;
                   
                }
                else
                    rightWall = height[r]; 
                 r--;
            }
        }
        
        return result;
    }
}