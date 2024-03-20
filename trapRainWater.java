class Solution {
    public int trap(int[] height) {
        // Tc: O(n) Sc: O(1)
        int l = 0;
        int r = height.length - 1;
        int lMax = height[l];
        int rMax = height[r];

        int res = 0;

        while (l < r) {
            if (lMax < rMax) {
                l += 1;
                lMax = Math.max(lMax, height[l]);
                res += lMax - height[l];
            } else {
                r -= 1;
                rMax = Math.max(rMax, height[r]);
                res += rMax - height[r];
            }
        }

        return res;

    }
}