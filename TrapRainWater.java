// Approach: Two pointer approach
// TC: O(n)
// SC: O(1)

class TrapRainWater {
    public int trap(int[] height) {
        int ans = 0;
        int i = 0;
        int j = height.length - 1;
        int lm = 0, rm = 0;
        while (i < j) {
            if (height[i] < height[j]) {
                lm = Math.max(lm, height[i]);
                ans += lm - height[i];
                i++;
            } else {
                rm = Math.max(rm, height[j]);
                ans += rm - height[j];
                j--;
            }
        }
        return ans;
    }
}