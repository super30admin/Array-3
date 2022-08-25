//Time Complexity: O(n)
//Space Complexity: O(1)

class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0)
            return 0;

        int n = height.length;
        int l = 0, r = n - 1;
        int lw = 0, rw = 0;
        int result = 0;

        while (l <= r) {
            if (lw <= rw) {
                if (height[l] < lw) {
                    result += lw - height[l];
                } else {
                    lw = height[l];
                }
                l++; // for either of the cases the left ptr moves forward by 1.
            } else {
                if (height[r] < rw) {
                    result += rw - height[r];
                } else {
                    rw = height[r];
                }
                r--;
            }
        }

        return result;

    }
}