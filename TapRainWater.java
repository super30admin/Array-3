// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

public class TapRainWater {
    public int trap(int[] height) {
        int result = 0;

        // left pass upto that maxIndex
        int l = 0; int r = height.length - 1;
        int lw = 0; int rw = 0;
        while(l <= r) {
            // check which wall is smaller
            if(lw <= rw) {
                // left side
                if(lw < height[l]) {
                    lw = height[l];
                }
                else {
                    result += lw - height[l];
                }
                l++;
            }
            else {
                // right side
                if(rw < height[r]) {
                    rw = height[r];
                }
                else {
                    result += rw - height[r];
                }
                r--;
            }
        }
        return result;
    }
}
