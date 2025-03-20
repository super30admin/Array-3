// In this problem, using 4 pointers, left wall which is 0, right wall which is 0, left pointer which is index that gives 
// height[left] value, and right index which gives height[right] value. Running a while loop till left is less than or equal to 
// right, checking which wall is smaller, moving to that side and checking corresponding pointer wall value, if smaller that means
// we have a depth between left and right walls, so adding to total, but if no depth, making the wall at the pointer our new wall.

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public int trap(int[] height) {
        // Base case
        if (height == null || height.length == 0) {
            return 0;
        }
        // 4 variables, 2 walls and 2 pointers moving between the walls to find a depth
        int total = 0;
        int lw = 0;
        int left = 0;
        int rw = 0;
        int right = height.length - 1;
        // Loop till left<=right
        while (left <= right) {
            // Check which wall is smaller
            if (lw <= rw) {
                // Check on that side if wall at the corresponding pointer is smaller than that
                // wall, then add to total
                if (height[left] < lw) {
                    total = total + (lw - height[left]);
                } else {
                    // Else make that wall at pointer our new wall
                    lw = height[left];
                }
                // In either case move the left pointer
                left++;
            } else {
                // Else if the right wall is smaller move to this side and check if the wall at
                // right pointer is smaller than the right wall, yes than we have depth, so add
                // to total
                if (height[right] < rw) {
                    total = total + (rw - height[right]);
                } else {
                    // Else make the wall at right pointer our new right wall
                    rw = height[right];
                }
                // In either case decrement the right pointer
                right--;
            }
        }
        // Return total
        return total;
    }
}