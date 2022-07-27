public class TrapRainWaterOnePass {

    public int trap(int[] height) {
        int n=height.length;
        int l=0;int r=n-1;
        int result=0;
        int lw=height[0];int rw=height[n-1];
        while(l<=r){
            if(lw<=rw){
                if(height[l]<lw){
                    result+=lw-height[l];
                }else{
                    lw=height[l];
                }
                l++;
            }else{
                if(height[r]<rw){
                    result+=rw-height[r];
                }else{

                    rw=height[r];
                }
                r--;
            }

        }

        return result;
    }
}
