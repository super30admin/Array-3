// Time Complexity : o(n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Leetcode : 42
//Approach : 2-pointer


class Solution {
    public int trap(int[] height) {
        if(height == null || height.length==0) return 0;
        
        int l = 0, r = height.length-1;
        int lw = height[l], rw = height[r];
        int res =0 ;
        
        while(l<=r){
            if(lw<=rw){
                if(height[l]<=lw){
                    res+=lw-height[l];
                }
                else{
                    lw = height[l];
                }
                l++;
            }
            else{
                 if(height[r]<=rw){
                    res+=rw-height[r];
                }
                else{
                    rw = height[r];
                }
                r--;
            }
        }
        
        return res;
    }
}