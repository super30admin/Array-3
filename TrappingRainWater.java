//Time complexity : O(n)
//Space complexity : O(1)
class Solution {
    public int trap(int[] height) {

        if (height == null || height.length==0) return 0;

        int result = 0;
        int n = height.length;
        int l = 0, lw = 0, rw = 0;
        int r = n - 1;

        while (l<=r) {
            if (lw <= rw) {
                if (height[l] < lw) {
                    result += lw - height[l];
                } else {
                    lw = height[l];
                }
                l++;
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
