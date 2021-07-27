
// Time - O(N)
// Space - O(1)


class Solution {
    public int trap(int[] height) {

        if(height == null || height.length < 2) return 0;

        int l = 0; int r = height.length - 1;
        int lw = 0; int rw = 0;
        int result = 0;

        while(l <= r) {

            if(lw <= rw) {
                // left case
                if(height[l] < lw) {
                    // trap the water
                    result += lw - height[l];
                }
                else {
                    // cannot trap water move lw to position of l
                    lw = height[l];
                }
                l++;
            }
            else {

                if(height[r] < rw) {
                    // trap the water
                    result += rw - height[r];
                }
                else {
                    // cannot trap water move rw to position of r
                    rw = height[r];
                }
                r--;
            }
        }

        return result;

    }
}