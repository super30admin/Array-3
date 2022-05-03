//Time Complexity O(N)
//Space Complexity O(1)
//Leetcode tested

public class TrappingRainWater {
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        int result = 0;
        int l =0, r = height.length-1;
        int lw=0,rw=0;
        while (l<=r){
            if(lw<=rw){
                if(height[l]<lw){
                    result = result + (lw - height[l]);
                }else{
                    lw = height[l];
                }
                l++;
            }else{
                if(height[r]<rw){
                    result = result + (rw - height[r]);
                }else{
                    rw = height[r];
                }
                r++;
            }
        }
        return result;
    }
}
