//Time Complexity - O(n)
//Space Complexity - O(1)
class TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int lw = 0;
        int l = 0;
        int rw = 0;
        int total = 0;
        int r = height.length - 1;
        while (l <= r) {
            if (lw <= rw) {
                if (height[l] < lw) {
                    total = total + lw - height[l];
                } else {
                    lw = height[l];
                }
                l++;
            } else {
                if (height[r] <= rw) {
                    total = total + rw - height[r];
                } else {
                    rw = height[r];
                }
                r--;
            }
        }
        return total;
    }
}
