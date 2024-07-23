// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// 1. Initialize two pointers (`l` and `r`) to traverse the height array from both ends, and two variables (`lw` and `rw`) to keep track of the left and right maximum heights encountered so far.
//2. Traverse the array: if the left max (`lw`) is less than or equal to the right max (`rw`), update the water trapped at the left pointer (`l`); otherwise, update the water trapped at the right pointer (`r`).
//3. Continue until the pointers meet, accumulating the total trapped water, and return the result.

class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int lw = 0, rw = 0, l = 0, r = height.length - 1;
        int total = 0;
        while (l <= r) {
            if (lw <= rw) {
                if (lw >= height[l]) {
                    total = total + (lw - height[l]);
                } else {
                    lw = height[l];
                }
                l++;
            } else {
                if (rw >= height[r]) {
                    total = total + (rw - height[r]);
                } else {
                    rw = height[r];
                }
                r--;
            }
        }
        return total;
    }
}