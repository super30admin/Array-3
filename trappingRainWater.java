// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :Test cases


// Your code here along with comments explaining your approach
class Solution {
    public int trap(int[] height) {
      
      if(height == null || height.length == 0)
      {
        return 0;
      }
      
      int leftMax = 0;
      int rightMax = 0;
      
      int l = 0;
      int r = height.length-1;
      
      int area =0;
      
      while(l < r)
      {
        leftMax = Math.max(leftMax,height[l]);
        rightMax = Math.max(rightMax,height[r]);
        
        if(leftMax < rightMax)
        {
          area = area + (leftMax - height[l]);
          l++;
        }
        else
        {
          area = area + (rightMax - height[r]);
          r--;
        }
      }
        return area;
    }
}