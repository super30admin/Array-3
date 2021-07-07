// Time Complexity - O(n) where n is the number of elements in the elevation map
// Space Complexity - O(1)
// This solution worked on Leetcode

class Solution {
    public int trap(int[] height) {
        int result = 0;
        int start = 0;
        int end = height.length - 1;
        while (start < end) {
            if (height[start] <= height[end]) {   // if start is less than the right , then process the start elevation and increment start
                int current = height[start];
                while (height[++start] < current) { // if the next elevation is less than the start elevation then add the difference in elevation to result and incrememt start
                    result += current - height[start];
                }
            } else {
                int current = height[end];    // else process the end elevation and move to left
                while(height[--end] < current) {        // if the previous elevation to end is less than the end add the difference in the elevation to the result and decrement end
                    result += current - height[end];
                }
            }
        }
        return result;
    }
}
