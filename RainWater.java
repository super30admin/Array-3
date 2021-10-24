// time complexity O(n)
// space complexity O(1)
public class RainWater {
    public int trap(int[] height) {
        if (height == null || height.length == 0)
            return 0;

        int lw = 0;
        int l = 1;
        int rw = height.length - 1;
        int r = height.length - 2;
        int result = 0;
        while (l <= r && l < height.length) {
            if (height[lw] <= height[rw]) {
                if (height[lw] < height[l]) {
                    lw = l;
                } else {
                    result += height[lw] - height[l];
                }
                l++;
            } else {
                if (height[rw] < height[r]) {
                    rw = r;
                } else {
                    result += height[rw] - height[r];
                }
                r--;
            }
        }
        return result;
    }
}
