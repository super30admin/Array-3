class Solution {
    // TC:O(n) SC:O(1)
    public int trap(int[] h) {
        if (h == null || h.length == 0)
            return 0;
        int lw = 0;
        int rw = 0;
        int l = 0;
        int r = h.length - 1;
        int result = 0;
        while (l <= r) {
            if (lw <= rw) {
                // left side
                if (h[l] < lw) {
                    result += lw - h[l];
                } else {
                    lw = h[l];
                }
                l++;
            } else {
                // right
                if (h[r] < rw) {
                    result += rw - h[r];
                } else {
                    rw = h[r];
                }
                r--;
            }
        }
        return result;
    }
}