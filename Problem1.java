class Solution {
    public int trap(int[] height) {
        int maxHeight = 0;
        int maxInd = -1;

        for (int i = 0; i < height.length; i++) {
            if (maxHeight < height[i]) {
                maxHeight = height[i];
                maxInd = i;
            }
        }

        int res = 0;

        int lw = 0;
        for (int i = 0; i < maxInd; i++) {
            if (height[i] < lw) {
                res = res + (lw - height[i]);
            } else {
                lw = height[i];
            }
        }

        int rw = 0;
        for (int i = height.length - 1; i > maxInd; i--) {
            if (height[i] < rw) {
                res = res + (rw - height[i]);
            } else {
                rw = height[i];
            }
        }
        return res;
    }
}