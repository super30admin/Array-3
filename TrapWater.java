/**
LeetCode Submitted : Yes
Space Complexity : O(1)
Time Complexity : O(N)


The idea is to use 4 pointers left right at each end of histogram. Then have Max left wall poiting to left position and Max right wall at right position. Update Maxleft wall and Maxright wall if maxleftwall/maxrightwall >= current height. Else that position will trap the water.
**/
class Solution {
    public int trap(int[] height) {
     
        if(height == null || height.length < 1)
            return 0;
        
        int n = height.length - 1;
        
        int left  = 0; //left pointer at start of histogram
        int right = n; //right pointer at end of histogram
        
        int leftWall  = 0; //Max wall at left position
        int rightWall = 0; //Max wall at right position
        
        int capacity = 0;
        
        while(left < right){
            if(height[left] < height[right]){
                //check current wall height
                if(leftWall > height[left]){
                    capacity += leftWall - height[left];
                }else{
                    leftWall =  height[left];
                }
                left++;
            }
            else{
                if(rightWall > height[right]){
                    capacity += rightWall - height[right];
                }else{
                    rightWall = height[right];
                }
                right--;
            }
            
        }
        return capacity;
        
    }
}
