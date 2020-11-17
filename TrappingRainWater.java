// Time Complexity : O(N) - As we iterate the whole array
// Space Complexity : O(N) - AS We use two 1D arrays for lwft max and right max
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int trap(int[] height) {
        if(height.length == 0) return 0;
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        int count = 0;
        left[0] = height[0];
        right[height.length - 1] = height[height.length - 1];
        int i = 1;
        int j = height.length - 2;
        while(i < height.length - 1 && j >= 0){
            left[i] = Math.max(left[i - 1],height[i]);
            right[j] = Math.max(right[j + 1],height[j]);
            i++;
            j--;
        }
        for(int k = 1;k < height.length - 1;k++){
            count += Math.min(left[k],right[k]) - height[k];
        }
        return count;
    }
}
// Your code here along with comments explaining your approach