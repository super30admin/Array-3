/**
    Time Complexity : O(N)
    Explanation:
    1) One pass to find the maximum bar index.
    2) One pass from left to max index.
    3) One pass from right to max index.
    Total is linear.

    Space Complexity : O(1)
    Explanation:
    Uses only a few variables, no extra arrays.

    Did this code successfully run on LeetCode : Yes

    Any problem you faced while coding this :
    Initially confused about how to handle left and right boundaries together.
    Fixed it by using the tallest bar as a divider:
    - Compute trapped water from left to tallest using left max
    - Compute trapped water from right to tallest using right max
    This avoids needing prefix/suffix arrays.
    */

    class Solution {

    
        public int trap(int[] height) {
    
            int result = 0;
            int max = 0;
            int maxIdx = -1;
            int n = height.length;
    
            // Find tallest bar and its index
            for (int i = 0; i < n; i++) {
                if (max < height[i]) {
                    max = height[i];
                    maxIdx = i;
                }
            }
    
            // Left to maxIdx
            int l = 0;
            int lw = 0; // left wall (max so far)
            while (l < maxIdx) {
                if (lw < height[l]) {
                    lw = height[l];
                } else {
                    result += lw - height[l];
                }
                l++;
            }
    
            // Right to maxIdx
            int r = n - 1;
            int rw = 0; // right wall (max so far)
            while (r > maxIdx) {
                if (rw < height[r]) {
                    rw = height[r];
                } else {
                    result += rw - height[r];
                }
                r--;
            }
    
            return result;
        }
    }