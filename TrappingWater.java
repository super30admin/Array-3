// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
// Two pointers
class Solution {
    public int trap(int[] height) {
        if(height==null || height.length==0)
            return 0;
        
        int left = 0;
        int right = height.length-1;
        
        int max_left =0;
        int max_right =0;
        int res = 0;
        while(left < right){
            if(height[left] < height[right]){
                if(height[left] >= max_left){
                    max_left = height[left];
                }else{
                    res += max_left - height[left];
                }
                left++;
            }else{
                if(height[right] >= max_right){
                    max_right = height[right];
                }else{
                    res += max_right - height[right];
                }
                right--;
            }
        }
        return res;
    }
}


