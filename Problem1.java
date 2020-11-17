// Time Complexity: O(N)
// Space Complexity: O(N)
// Passed Leetcode

class Solution {
    public int trap(int[] height) {
        
        if (height.length == 0)
            return 0;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int n = height.length - 1;
        for (int i = 0; i < height.length; i++) {
            if (i == 0)
                continue;
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
            rightMax[n - i] = Math.max(rightMax[n - i + 1], height[n - i + 1]);
        }
        
        int total = 0;
        
        for (int i = 0; i <= n; i++) {
            int curr = Math.min(leftMax[i], rightMax[i]) - height[i];
            if (curr > 0)
                total += curr;
            
        }
        
        return total;
    }
}