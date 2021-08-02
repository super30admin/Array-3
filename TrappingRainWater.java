class Solution {

    //O(n) time and O(1) time
    public int trap(int[] height) {

        if (height == null || height.length < 2) return 0;
        int result = 0;
        int l = 0; int r = height.length - 1;
        int lw = 0; int rw = 0;

        while (l <= r) {

            if (lw <= rw) {
                //process left if its less than first
                //can only trap water if height is less than wall
                if (height[l] < lw) {
                    result += lw - height[l];
                } else {
                    lw = height[l];
                }
                l++;
            } else {
                //process right
                //can only trap wateri f height is less than wall
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