public class TrapRainWater {
    public int trap(int[] height) {
        if(height==null||height.length==0)return 0;
        int result = 0;
        int l=0;int r = height.length-1;
        int lw=0;
        int rw=0;
        while(l<=r){
            if(lw<=rw){
                //left
                if(height[l]>=lw){
                    lw = height[l];
                }
                else{
                    //trap the water
                    result+=(lw-height[l]);
                }
                l++;
            }
            else{
                //right
                if(height[r]>=rw){
                    rw = height[r];
                }
                else{
                    //trap
                    result+=(rw-height[r]);
                }
                r--;
            }

        }
        return result;
    }
}
