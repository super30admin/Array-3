//T.C = O(n)
//S.C =O(1)
class Solution {
    public int trap(int[] height) {
        int result=0;
        int lw=0,rw=0;
        int l=0,r=height.length-1;
        while (l<=r){
            if(lw<=rw){
                if(lw > height[l]){
                    result=result+lw-height[l];
                }else{
                    lw=height[l];
                }
                l++;
            }else{
                if(rw>height[r]){
                    result=result+rw-height[r];
                }else{
                    rw=height[r];
                }
                r--;
            }
        }
        
        return result;
    }
}
