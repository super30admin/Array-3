//tc is O(n)
//sc is O(1)
class Solution {
    public int trap(int[] height) {

        if (height == null)
            return 0;

        int lw = 0;
        int rw = 0;
        int l = 0;
        int r = height.length - 1;
        int result = 0;

        while (l <= r) {
            if (lw <= rw) {

                if (height[l] < lw) {
                    result = result + (lw - height[l]);
                } else {
                    lw = height[l];

                }
                l++;
            } else {
                // lw is larger

                if (height[r] < rw) {
                    result = result + (rw - height[r]);
                } else {
                    rw = height[r];

                }

                r--;

            }
        }

        return result;
    }
}