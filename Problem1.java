// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//We use two pointers from both ends and keep track of the tallest walls on each side.
//if the left wall is greater than right wall, left wall acts as dam and water can  be trapped on right side and vice versa
//We add trapped water if current height is less than the known max wall on that side.
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int lw = 0;
        int rw = 0;
        int l = 0;
        int r = n - 1;
        int res = 0;
        while (l <= r) {
            //right wall is bigger and acting as a right dam, so that water can be trapped on left side
            if (lw < rw) {
                if (height[l] < lw) {
                    //water can be trapped
                    res += 1 * (lw - height[l]);
                } else {
                    //no water can be stored
                    lw = height[l];
                }
                l++;

            } else {
                //left wall is bigger and acting as a left dam so that water can be trapped on right side
                if (height[r] < rw) {
                    res += 1 * (rw - height[r]);
                } else {
                    rw = height[r];
                }
                r--;
            }
        }
        return res;

    }
}
