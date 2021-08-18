// TC: O(n)
// SC: O(1)

class Solution {
    public int trap(int[] height) {
        if(height == null || height.length < 2) {
            return 0;
        }
        int l, r, lw, rw, result, n;
        n = height.length;
        l = 0; r = n - 1;
        lw = 0; rw = 0;
        result = 0;
        while(l <= r) {
            if(lw <= rw) {
                if(height[l] < lw) {
                    result += lw - height[l];
                } else {
                    lw = height[l];
                }
                l++;
            } else {
                if(height[r] < rw) {
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