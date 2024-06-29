// Time Complexity : O(m+n)= O(n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes, https://leetcode.com/problems/trapping-rain-water/
// Any problem you faced while coding this : No


class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int result = 0;
        int lw = 0;
        int rw = 0;
        int l = 0;
        int r = n-1;
        while(l<r){
            if(lw<=rw){
                //rw is acting as dam, process left side
                if(height[l]<lw){
                    result+=lw-height[l];
                }else{
                    lw = height[l];
                }
                l++;
            }else{
                if(height[r]<lw){
                 result+=rw-height[r];
            }else{
                rw = height[r];
            }
            r--;
        }
    }
    return result;
}
}
