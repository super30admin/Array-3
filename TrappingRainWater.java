//TC: O(n)
//SC: O(1)
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int l = 1; int r = n-2;
        if(n < 2) return 0;
        int lw = height[0]; int rw = height[n-1];
        int res = 0;
        while(l <= r){
            if(lw <= rw){//left can be processed
                if(lw >= height[l]){
                    res += lw - height[l];
                    l++;
                }
                else{
                    lw = height[l];
                }
                
            }
            else{
                if(rw >= height[r]){
                    res += rw - height[r];
                    r--;
                }
                else{
                    rw = height[r];
                }
            }
        }
        return res;
    }
}
