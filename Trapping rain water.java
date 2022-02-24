//Time complexity: O(n)
//Space complexity: O(1)

class Solution {
    public int trap(int[] height) {
        int lw=0; int rw=0;
        int lh=0;
        int n=height.length;
        int rh= n-1;
        int area=0;
        
        while(lh<=rh)
        {
            if(lw<=rw)
            {
                if(height[lh]<lw)
                {
                    
                    area+= (lw-height[lh]);
                   
                }
                else
                lw=height[lh];
                 lh++;
            }
            else
            {
                if(height[rh]<rw)
                {
                    
                    area+=(rw-height[rh]);
                    
                }
                else
                rw=height[rh];
                 rh--;
               
            }
        }
        return area;
        
    }
}