// TC: O(n)
// SC: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    // TC = O(n), SC = O(1)
    // keep track of the lower wall & use l/r to calc water
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        int n = height.length;
        int left = 0, lw = 0; // left wall
        int right = n - 1, rw = 0;
        int total = 0;
        while(left <= right) { // let the pointer cross each other
            if(lw <= rw) { // find the wall with smaller height, here the right wall will prevent the water from flowing away
                if(height[left] < lw) { // can trap water
                    total += lw - height[left];
                }
                else {
                    lw = height[left]; // move lw to higher height to trap water
                }
                left++; // move left in any case
            }
            else { // higer wall on the left side
                if(height[right] < rw) { // can trap water
                    total += rw - height[right];
                }   
                else {
                    rw = height[right];
                }
                right--;
            }
        }
        return total;
    }
}