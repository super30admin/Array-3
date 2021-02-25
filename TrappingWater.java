// 2 pointer technique -> use 4 pointers
// TC: O(N)
// SC: O(1)
// Did it run successfully on Leetcode? : Yes
class Solution {
    public int trap(int[] height) {
        if ( height == null || height.length < 2 )
            return 0;
        
        int left = 0;   // index pointer
        int right = height.length - 1;  // index pointer
        int left_max = 0; // represent height not index
        int right_max = 0; // represent height not index
        int result = 0;
        
        while ( left <= right)
        {
           if (left_max <= right_max)
           {
               if (height[left] <= left_max )
               {    
                   result = result + (left_max - height[left]);         
               }
               else
               {
                   left_max = height[left];
               }
               left++;
           }
          else
          {
              if (height[right] <= right_max )
               {    
                   result = result + (right_max - height[right]);       
               }
              else
              {
                  right_max = height[right];
              }
              right--;
          }   
        }
        return result;
    }
}
