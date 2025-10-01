class Solution {
    //We find the index of maximum right side and calculate water each wall can hold relative to max. right wall
    //We find the index of maximum left side and calculate water each wall can hold relative to max. left wall, max.right wall
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public int trap(int[] height) {
       int maxheight = Integer.MIN_VALUE;
       int maxIndex = -1;
       for(int i=0;i<height.length;i++)
       {
         if(height[i]>maxheight)
         {
            maxheight = height[i];
            maxIndex = i;
         }
       }

       int result = 0;
       int lw = 0, l = 0;

       while(l<maxIndex)
       {
         if(height[lw]>height[l])
         {
            result += height[lw]-height[l];
         }
         else
         {
            lw = l;
         }
         l++;
       } 

       int rw = height.length-1, r = height.length-1;

       while(r>maxIndex)
       {
        if(height[rw]>height[r])
        {
            result += height[rw]-height[r];
        }
        else
        {
            rw = r;
        }
        r--;
       }

       return result;
    }
}