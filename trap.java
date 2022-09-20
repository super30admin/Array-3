//TC - O(n);
//SC - O(1);
//LC - 42;
class Solution {
    public int trap(int[] height) {
        
        int len = height.length;
        
        if(len==0 || len==1 || len==2) return 0;
        
        int l = 0;
        int r = len-1;
        
        int lw=0,rw=0;
        int result=0;
        
        while(l<=r){
            if(lw<=rw){
                if(height[l]<lw){
                    result += lw-height[l];
                }
                else{
                    lw=height[l];
                }
                l++;
            }
            else{
                if(height[r]<rw){
                    result += rw-height[r];
                }
                else{
                    rw=height[r];
                }
                r--;
                
            }
        }
        
        return result;
        
    }
}