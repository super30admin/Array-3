// Time Complexity : O(n) because we traverse the array once using two pointers
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We use two pointers and maintain the highest wall seen so far from both the left and right sides.
// Water can be trapped on the side with the smaller wall because a taller wall is guaranteed on the opposite side.
// At each step, we compute trapped water using the current boundary wall and move the corresponding pointer inward.

class Solution {
    public int trap(int[] height) {

        int n = height.length;

        int lw = 0, l = 0;
        int rw = n - 1, r = n - 1;

        int result = 0;

        while(l <= r) {

            // process side with smaller wall
            if(height[lw] <= height[rw]) {

                if(height[l] <= height[lw]) {
                    result += height[lw] - height[l];
                } else {
                    lw = l;
                }

                l++;
            } else {

                if(height[r] <= height[rw]) {
                    result += height[rw] - height[r];
                } else {
                    rw = r;
                }

                r--;
            }
        }

        return result;
    }
}