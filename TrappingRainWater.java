// Time Complexity : O(n), n = length of the array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

class Solution {
    public int trap(int[] height) {
        if(height == null || height.length <= 2)
            return 0;
        
        int left=0, lw=0, right=height.length-1, rw=0, result = 0;
        
        while(left <= right) {
            if(lw <= rw) {
                if(height[left] < lw)
                    result += lw-height[left];
                else
                    lw = height[left];
                left++;
            }
            else {
                if(height[right] < rw) 
                    result += rw-height[right];
                else
                    rw = height[right];
                right--;
            }
        }
        return result;
    }
}