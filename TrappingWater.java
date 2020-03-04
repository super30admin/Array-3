/*
 * Time complexity : O(n)
 * Space Complexity : O(1)
 */

class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        
        int leftWall = 0;
        int rightWall = 0;
        int left = 0;
        int right = height.length - 1;
        
        int count = 0;
        
        while(left <= right){
           
            if(leftWall < rightWall){
                //left side
                if(leftWall < height[left]){
                    leftWall = height[left];
                }else{
                    count += leftWall - height[left];
                }

                left++;
            }else{
                if(rightWall < height[right]){
                    rightWall = height[right];
                }else{
                    count += rightWall - height[right];
                }
                
                right--;
            }
        }
        
        return count;
    }
}