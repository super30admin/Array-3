//TC: O(n)
//SC: O(1)

public class TrappingRainWater {
    public int trap(int[] height) {
        
        int lw = 0, rw = 0, l = 0, r = height.length-1, total = 0;
        while(l <= r){
            if(lw < rw){
                //calculate left side
                if(lw < height[l]){
                    lw = height[l];
                }
                else{
                    total += lw - height[l];
                }
                l++;
            }
            else{
                //calculate right side
                if(rw < height[r]){
                    rw = height[r];
                }
                else{
                    total += rw - height[r];
                }
                r--;
            }
        }
        return total;
        
    }
}