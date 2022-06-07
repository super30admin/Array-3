public class Problem1 {
    // TC : O(n)
    // SC : O(1)
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;

        int n = height.length - 1;
        int left = 0;
        int right = n;
        int lw = 0, rw = 0;
        int result = 0;
        while (left <= right) {
            if (lw <= rw) {

                if (lw > height[left]) {
                    result = result + lw - height[left];
                } else {
                    lw = height[left];
                }
                left++;
            } else {
                if (rw > height[right]) {
                    result = result + rw - height[right];
                } else {
                    rw = height[right];
                }
                right--;
            }
        }
        return result;
    }
}
