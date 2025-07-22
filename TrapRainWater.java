// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : for each index find left and right walls. The water that can be trapped at current index is the
/// minimum heght of those walls -curr element

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int left[] = new int[n];
        left[0] = 0;
        for(int i=1;i<n;i++){
            left[i] = Math.max(left[i-1], height[i-1]);
        }
        int right = 0;
        int res = 0;
        for(int i=n-2;i>0;i--){
            right = Math.max(right, height[i+1]);
            if(Math.min(right, left[i])>height[i])
                res += Math.min(right, left[i])-height[i];
        }
        return res;
    }
}