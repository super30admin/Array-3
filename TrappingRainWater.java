// Time complexity :O(n)
// Space Complexity :O(1)
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) return 0;

        int maxIdx = -1;
        int max = 0;

        for (int i = 0; i < n; i++) {
            if (height[i] > max) {
                max = height[i];
                maxIdx = i;
            }
        }

        int result = 0;

        int l = 0;
        int lw = height[0];
        while (l < maxIdx) {
            if (height[l] < lw) {
                result += lw - height[l];
            } else {
                lw = height[l];
            }
            l++;
        }

        int r = n - 1;
        int rw = height[n - 1];
        while (r > maxIdx) {
            if (height[r] < rw) {
                result += rw - height[r];
            } else {
                rw = height[r];
            }
            r--;
        }

        return result;
    }
}
