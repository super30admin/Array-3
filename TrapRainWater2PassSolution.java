// Time Complexity : O(2n)-> O(n);
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

public class TrapRainWater2PassSolution {
    public int trap(int[] height) {

        int maxHeight=0, maxIdx=0;
        int result = 0;

        for(int i=0; i<height.length; i++)
        {
            if(maxHeight < height[i])
            {
                maxHeight = height[i];
                maxIdx = i;
            }
        }
        int l=0;
        int lw=height[l];

        while(l<maxIdx)
        {
            if(lw > height[l])
            {
                result += lw - height[l];
            }else{
                lw = height[l];
            }
            l++;
        }

        int r=height.length-1; int rw = height[r];
        while(r>maxIdx)
        {
            if(rw > height[r])
            {
                result += rw - height[r];
            }else{
                rw = height[r];
            }
            r--;
        }
        return result;

    }
}
