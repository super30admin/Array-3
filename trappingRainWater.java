// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        int lw = 0; int rw = 0; // heights
        int l = 0; int r = height.length - 1; int result = 0;
        while(l <= r){
            if(lw <=rw){
                // left side
                if(height[l] < lw){
                    result += (lw - height[l]) * 1;
                }else{
                    lw = height[l];
                }
            l++;
            }else{ 
                // right side
                if(height[r] < rw){
                    result += (rw - height[r]) * 1;
                }else{
                    rw = height[r];
                }
            r--;
            }
        }
        return result;
    }
}