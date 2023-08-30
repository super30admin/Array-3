// Time Complexity : O(n);
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

public class TrapRainWater1PassSolution {
    public int trap(int[] height) {

        int result = 0;

        int l = 0;
        int lw = height[l];
        int r=height.length-1; int rw = height[r];

        while(l<= r)
        {
            if(lw <= rw)
            {
                if(lw > height[l])
                {
                    result += lw - height[l];
                }else{
                    lw = height[l];
                }
                l++;
            }else{
                if(rw > height[r])
                {
                    result += rw - height[r];
                }else{
                    rw = height[r];
                }
                r--;
            }
        }
        return result;

    }
}

