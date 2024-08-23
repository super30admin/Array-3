// Time Complexity: O(n^2)
// Space Complexity: O(1)

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int lw = 0;
        int rw = n - 1;
        int l = 1;
        int r = n - 2;
        int result = 0;

        while (l <= r) {
            if (height[lw] <= height[rw]) {
                if (height[l] <= height[lw])
                    result += height[lw] - height[l];
                else
                    lw = l;
                l++;
            } else {
                if (height[r] <= height[rw])
                    result += height[rw] - height[r];
                else
                    rw = r;
                r--;
            }
        }

        return result;
    }
}