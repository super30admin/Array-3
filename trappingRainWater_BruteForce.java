// Time Complexity : O(n^2) where n is the length of the height array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Iterate thru every every index in the array except first and last, keeping count of max height in both the
// directions including itself. Max water that can be trapped at that index is the minimum of the max heights
// in both the directions minus the height at its own index. 


class trappingRainWater_BruteForce {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) return n;
        int ans = 0;
        for (int i = 1; i < n - 1; i++) {
            int maxLeft = 0, maxRight = 0;
            for (int j = 0; j <= i; j++) {
                maxLeft = Math.max(maxLeft, height[j]);
            }
            for (int j = i; j < n; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }
            ans += Math.min(maxLeft, maxRight) - height[i];
        }
        return ans;
    }
}