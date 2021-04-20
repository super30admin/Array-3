// Time Complexity : O(3n) => O(n) n- length of heights array
// Space Complexity : O(n) for left[] and right[] arrays
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

// Using Dynamic programming approach

class Solution {
    public int trap(int[] height) {
        if(height == null || height.length==0) return 0;
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = height[0];
        right[n-1] = height[n-1];
        for(int i=1;i<n;i++){
            left[i] = Math.max(height[i],left[i-1]);
        }
        for(int i=n-2;i>=0;i--){
            right[i] = Math.max(height[i],right[i+1]);
        }
        int res=0;
        for(int i=0;i<n;i++){
            res += Math.min(left[i],right[i])-height[i];
        }
        return res;
    }
}
