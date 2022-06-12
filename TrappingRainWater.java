// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int l = 0, r = n - 1;
        int lw = 0, rw = 0;
        int result = 0;
        
        while(l <= r) {
            if(lw <= rw) {
                //Process the left part
                
                if(lw >= height[l]) {
                    result += (lw - height[l]);
                } else {
                    lw = height[l];
                }
                l++;
            } else{
                // Process the right part
                
                if(rw >= height[r]) {
                    result += (rw - height[r]);
                } else {
                    rw = height[r];
                }
                r--;
            }
        }
        
        return result;
    }
}