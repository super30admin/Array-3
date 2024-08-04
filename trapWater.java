class trapWater {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int lw = 0, rw = 0;
        int l = 0, r = height.length - 1;
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

    public static void main(String[] args) {
        trapWater s = new trapWater();
        int[] height = { 4, 2, 0, 3, 2, 5 };
        int ans = s.trap(height);
        System.out.println(ans);
    }
}