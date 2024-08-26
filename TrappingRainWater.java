// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class TrappingRainWater {
    // using single pass
    public int trap(int[] height) {
        int n = height.length;
        int result = 0;
        int l = 0;
        int lw = 0; // height of the wall
        int r = n - 1;
        int rw = 0; // height of the wall

        while (l <= r) {
            // which side to process
            if (lw <= rw) {
                // process left
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
    View less
