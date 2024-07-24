// Time Complexity : O(n)
// Space Complexity : (1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length-1;
        int lw = 0;
        int rw = 0;
        int res = 0;
        while(l<=r){
            if(lw <= rw){
                if(lw >=height[l]){
                    res= res + lw - height[l];
                }
                else{
                    lw = height[l];
                }
                l++;
            }
            else{
                if(rw >= height[r]){
                    res = res + rw - height[r];
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