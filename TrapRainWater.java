public class TrapRainWater {
    public int trap(int[] height) {
        int result = 0;
        int l = 0, r = height.length-1;
        int lw = 0, rw = 0;
        while(l<=r){
            if(lw<=rw){
                if(height[l]<lw){
                    result+=lw-height[l];
                }else{
                    lw = height[l];
                }
                l++;
            }else{
                if(height[r]<rw){
                    result+=rw-height[r];
                }else{
                    rw = height[r];
                }
                r--;
            }
        }
        return result;
    }
}

// TC - O(n)
// SC - O(1)