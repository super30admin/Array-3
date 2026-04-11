// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
We use 2 pointers on either ends of the height array to first identify the tallest walls on both sides.Later,
we check the tallest left and right wall with each wall on either ends to find the minimum height of the wall
because thats how much water we can trap at the end of the day.We iterate until both pointers cross each other.
We only add water if current pointer's height is less than left wall and respectively with right pointer's height
to right wall comparison.
 */
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int l = 0, lw = 0;
        int r = n - 1 , rw = n - 1;
        int result = 0;
        while(l <= r) {
            if(height[rw] > height[lw]) {
                //confirmed that we have a bigger right wall, so check about left wall
                if(height[lw] > height[l]) {
                    result += height[lw] - height[l];
                }
                else {
                    lw = l;
                }
                l++;
            }
            else {
                if(height[rw] > height[r]) {
                    result += height[rw] - height[r];
                }
                else {
                    rw = r;
                }
                r--;
            }
        }
        return result;
    }
}