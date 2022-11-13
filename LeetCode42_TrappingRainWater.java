class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        
        int n = height.length;
        int  l =0, r =n-1, lw =0, rw =0;
        int area =0;
        while(height[l] < height[r])
        {
            if(height[lw] <= height[rw])
            {
                //process the left side
                if(height[lw] <= height[l])
                {
                    lw =l;
                    l++;
                }
                else
                {
                    area += (height[lw] -height[l]); 
                }
            }
            else
            {
                //process the right side
                if(height[rw] <= height[r])
                {
                    rw =r;
                    r--;
                }
                else
                {
                    area+= (height[rw] -height[r]);
                }
                
            }
        }
        return area;
    }
}