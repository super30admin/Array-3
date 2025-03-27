// Problem1 Trap Rain Water (https://leetcode.com/problems/trapping-rain-water/)

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, take pointers low at 0 and high at last index. Take leftWall as 0 and rightWall as 0 initially. Move until left<=right
 * Check if leftWall<=rightWall if yes, then check if leftWall is greater than value at left, if yes add leftWall-value to
 * result else make value as leftWall and the move left pointer, else, the check if rightWall is greater than value at rightt, if
 * yes add rightWall-value to result else make value as rightWall and the move right pointer. 
 */
// 1
class Solution {
    public int trap(int[] height) {
        int max = Integer.MIN_VALUE;
        int maxIdx = 0;
        for(int i = 0; i < height.length; i++){
            if(height[i]>max){
                max = height[i];
                maxIdx = i;
            }
        }
        // 0 to maxIdx
        int result = 0;
        int leftWall = 0;
        int left = 0;
        while(left<maxIdx){
            if(leftWall > height[left]){
                result += (leftWall - height[left]) * 1;
            }
            else{
                leftWall = height[left];
            }
            left++;
        }
        // maxIdx to right
        int rightWall = 0;
        int right = height.length-1;
        while(right>maxIdx){
            if(rightWall > height[right]){
                result += (rightWall - height[right]) * 1;
            }
            else{
                rightWall = height[right];
            }
            right--;
        }
        return result;
    }
}
// 2
class Solution {
    public int trap(int[] height) {
        int result = 0;
        int leftWall = 0;
        int left = 0;
        int rightWall = height[height.length-1];
        int right = height.length-1;
        while(left <= right){
            if(leftWall <= rightWall){
                if(leftWall > height[left]){
                    result += leftWall - height[left];
                }else{
                    leftWall = height[left];
                }
                left++;
            }
            else{
                if(rightWall > height[right]){
                    result += rightWall - height[right];
                }
                else{
                    rightWall = height[right];
                }
                right--;
            }
            
        }
        return result;
    }
}