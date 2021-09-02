//TC: O(N)
//SC:O(1)
class Solution {
    public int trap(int[] height) {
        if(height==null || height.length<2)
            return 0;
        int n=height.length,rain=0;
        
        int lw=0,rw=0,l=0,r=n-1;
        
        while(l<=r){
            if(lw<=rw){
                if(height[l]<lw){
                    rain+=(lw-height[l]);
                }else{
                    lw=height[l];
                }
                l++;
                
                
            }else{
                
               if(height[r]<rw){
                     rain+=(rw-height[r]);
                }else{
                     rw=height[r];
                }
                r--;     
            }    
        }
        return rain;
    }
}