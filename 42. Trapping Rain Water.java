// Time Complexity: O(n)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode: YES
// Any problem you faced while coding this: NO

class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        
        int n = height.length;
        int lw = 0, rw = 0;
        int l = 0, r = n - 1;
        int result = 0;
        
        while(l <= r){
            if(lw <= rw){
                if(height[l] < lw){
                    result += lw - height[l];
                }
                else{
                    lw = height[l];
                    
                }
                l++;
            }   
            else{
                if(height[r] < rw){
                    result += rw - height[r];
                }
                else{
                    rw = height[r];
                }
                r--;
            }
        }
        return result;
    }
}