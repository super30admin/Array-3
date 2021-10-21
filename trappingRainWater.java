// Time complexity: O(n)
// Space complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int trap(int[] height) {
        // check for empty or null height array
        if(height == null || height.length == 0) return 0;
        int result = 0;
        // intialize left and right pointers
        int l = 0;
        int r = height.length - 1;
        // intialize left wall pointer and right wall pointer
        int lw = 0;
        int rw = 0;
        // while left and right pointers don't cross each other
        while(l <= r){
            if(lw <= rw){
                // process left
                if(height[l] < lw){ // if height at l pointer is less than height of left wall
                    // update result
                    result += lw - height[l];
                } else {
                    lw = height[l]; // update height of left wall
                }
                l++; // update left pointer
            } else {
                // process right
                if(height[r] < rw){ // if height at r pointer is less than height of right wall
                    // update result
                    result += rw - height[r];
                } else {
                    rw = height[r]; // update height of right wall
                }
                r--; // update right pointer
            }
        }
        return result;
    }
}