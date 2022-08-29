//0(n)
class Solution {
    public int trap(int[] height) {
        if(height == null || height.length==0)
        {
            return 0;
        }
        int n= height.length;
        int result=0;
        int l=0;
        int lw=0;
        int r=n-1;
        int rw=0;
        while(l<=r)
        {
            if(lw<=rw)
            {
                if(height[l]<lw)
                {
                    result+=lw-height[l];
                }
                else
                {
                    lw=height[l];
                }
                l++;
            }
            else
            {
                if(height[r]<rw)
                {
                    result+=rw-height[r];
                }
                else
                {
                    rw=height[r];
                }
                r--;
            }
        }
        return result;

    }
}