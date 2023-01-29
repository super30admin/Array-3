// Time Complexity : O(n)
// Space Complexity :O(1)
class Solution {
    public int trap(int[] height) {
        if(height==null || height.length==0) return 0;
        int res=0;
        int lw=0, rw=0, l=0, r=height.length-1;
        while(l<=r){
            if(lw<=rw){
                if(height[l]<lw){
                    res=res+(lw-height[l]);
                }else{
                    lw=height[l];
                }
                l++;
            }else{
                 if(height[r]<rw){
                    res=res+(rw-height[r]);
                }else{
                    rw=height[r];
                }
                r--;
            }
        }
        return res;
    }
}