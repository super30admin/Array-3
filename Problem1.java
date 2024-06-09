package Array-3;
// TC: O(n)
// SC: O(1)
public class Problem1 {
    public int trap(int[] height) {
        int n = height.length;
        if(n==1) return 0;
        int l=0,lw=0;
        int r=n-1, rw=0;
        int result=0;
        while(l<=r){
            if(lw<=rw){
                if(lw>height[l]){
                    result+=lw-height[l];
                }else{
                    lw=height[l];
                }
                l++;
            }else{
                if(rw>height[r]){
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
