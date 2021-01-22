// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how
// much water it can trap after raining.
// TC O(N) SC O(1)
class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int n = height.length;
        int l = 0, r = n-1;
        int lMax = 0, rMax = 0;
        int result = 0;
        while (l<=r) {
            if (height[l] < height[r]) {
                if (height[l] >= lMax){
                    lMax = height[l];
                }
                else {
                    result += lMax - height[l];
                }
                l++;
            }
            else {
                if (height[r] >= rMax){
                    rMax = height[r];
                }
                else {
                    result += rMax - height[r];
                }
                r--;
            }
        }
        return result;
    }
}
