//Time-> o(n)
//Space-> O(1)

public class Problem1 {
    public int trap(int[] height) {
        int n = height.length; 
        int l = 0; 
        int r = n - 1; 
        int rw = 0; 
        int lw = 0;
        int result = 0;
        while(l <= r){
            if(lw <= rw){
                if(lw <= height[l]){
                    lw = height[l];
                }
                else{
                    result += lw - height[l];
                }
                l++;
            }
            else{
                if(rw <= height[r]){
                    rw = height[r];
                }
                else{
                    result += rw - height[r];
                }
                r--;
            }
        }
        return result;
    }
}
