// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int trap(int[] height) {
        int left = 0, leftMax = 0;
        int right = height.length-1, rightMax = 0;
        int result = 0;
        while(left <= right){
            if(height[left] <= height[right]){
                leftMax = Math.max(leftMax,height[left]);
                result += leftMax-height[left];
                left++;
            }else{
                rightMax = Math.max(rightMax,height[right]);
                result += rightMax-height[right];
                right--;
            }
        }
        return result;
        
        
        
        // int left = 0,leftMax = 0;
        // int right = height.length-1,rightMax = 0;
        // int result = 0;
        // while(left < right){
        //     if(height[left] <= height[right]){
        //         leftMax = Math.max(leftMax,height[left]);
        //         result += leftMax - height[left];
        //         left++;
        //     }else{
        //         rightMax = Math.max(rightMax,height[right]);
        //         result += rightMax - height[right];
        //         right--;
        //     }
        // }
        // return result;
        
    }
}
