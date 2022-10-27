class Solution {
    //tc- o(n)
    //sc-o(1)
    public int trap(int[] height) {
        if(height == null|| height.length == 0) return 0;
        int result = 0;
        int lw = 0;
        int rw = 0;
        int l=0;
        int r = height.length-1;
        while(l<=r)
        {
            if(lw <= rw)
            {
                //left process
                if(lw>height[l])
                {
                    result+= lw - height[l];
                }
                else
                {
                    lw = height[l];
                }
                l++;
            }
            else //right process
            {
                if(rw>height[r])
                {
                    result+= rw - height[r];
                }
                else{
                    rw = height[r];
                }
                r--;
            }
            
        }
        return result;
    }
}