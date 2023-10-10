//tc = O(n)
//sc = O(1)
public class TrappingRainWater {

}

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int l = 0;
        int r = n - 1;
        int area = 0;
        int lw = 0;
        int rw = 0;

        while (l <= r) {

            if (lw <= rw) {

                if (height[l] > lw) {
                    lw = height[l];
                } else {
                    area += lw - height[l];
                }
                l++;
            } else {
                if (height[r] > rw) {
                    rw = height[r];
                } else {
                    area += rw - height[r];
                }
                r--;
            }

        }
        return area;

    }
}
