class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int lw = 0;
        int l = 0;
        int rw = 0;
        int r = height.length - 1;
        int ans = 0;

        while (l <= r) {
            if (lw <= rw) {
                if (lw >= height[l]) {
                    ans+= lw - height[l];
                } else {
                    lw = height[l];
                }
                ++l;
            } else {
                if (rw >= height[r]) {
                    ans+= rw - height[r];
                } else {
                    rw = height[r];
                }
                r--;
            }
        }
        return ans;
    }
}