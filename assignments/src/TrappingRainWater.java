// Approach: Use 2 pointer approach but with 4 pointers - left, right, left wall, right wall
// Start pointers left from 0 and right from last index and keep adding water to result if
// it can be captured between the buildings
// Time: O(n)
// Space: O(1)

class TrappingRainWater {
    public int trap(int[] height) {
        int result = 0;
        int lw = 0, rw = 0;
        int l = 0, r = height.length-1;

        while (l <= r) {
            if (lw <= rw) {
                // process left side
                if (lw <= height[l]) {
                    lw = height[l];
                }
                else {
                    result += 1*(lw-height[l]);
                }
                l++;
            }
            else {
                // process right side
                if (rw <= height[r]) {
                    rw = height[r];
                }
                else {
                    result += 1*(rw-height[r]);
                }
                r--;
            }
        }
        return result;
    }
}