// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class trappingRainWater {
    public int trap(int[] height) {
        int result = 0;
        int start = 0;
        int end = height.length - 1;
        while (start < end) {
            if (height[start] <= height[end]) {
                int current = height[start];
                while (height[++start] < current) {
                    result += current - height[start];
                }
            } else {
                int current = height[end];
                while(height[--end] < current) {
                    result += current - height[end];
                }
            }
        }
        return result;
    }
}
