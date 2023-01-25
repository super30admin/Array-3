// Trapping Rain Water

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

class Solution {
    public int trap(int[] height) {
        int result = 0;
        int lw = 0;
        int rw = 0;
        int l = 0;
        int r = height.length - 1;
        while(l <= r){
            if(lw <= rw){
                //left side
                if(lw <= height[l]){
                    lw = height[l];
                } else {
                    result += 1 * (lw - height[l]);
                }
                l++;
            } else {
                //right side
                if(rw <= height[r]){
                    rw = height[r];
                }
                else{
                    result += 1* (rw - height[r]);
                }
                r--;
            }
        }
        return result;
    }
}