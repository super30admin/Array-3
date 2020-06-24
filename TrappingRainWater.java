//time o(n)
//space o(1)
class Solution {
    public int trap(int[] height) {
        if(height==null || height.length < 3) {
            return 0;
        }
        int len = height.length;
        int water=0;
        int lmax = height[0], rmax = height[len-1];
        int i=1, j=len-2;
        
        while(i <= j) {
            lmax = Math.max(lmax, height[i]);
            rmax = Math.max(rmax, height[j]);
            if(lmax < rmax)
            {
                water = water + lmax-height[i];
                i++;
            }
            else {
                water = water + rmax-height[j];
                j--;
            }
        }
        return water;
    }
}