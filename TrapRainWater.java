// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Create the prefixMax and suffixMax arrays for the given array
// Now water at particular index is min of prefixMax and suffixMax values at that index - height at that index
// We will iterate over and calculate the sum of these to find our result
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];
        prefixMax[0] = height[0];
        suffixMax[n-1] = height[n-1];
        int result = 0;
        for(int i = 1; i < n; i++){
            prefixMax[i] = Math.max(prefixMax[i-1], height[i]);
        }
        for(int i = n-2; i >=0; i--){
            suffixMax[i] = Math.max(suffixMax[i+1], height[i]);
        }
        for(int i = 0; i < n; i++){
            int val = Math.min(suffixMax[i], prefixMax[i]) - height[i];
            result += val;
        }
        return result;
    }
}