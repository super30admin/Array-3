//Time complexity O(n)
//Space complexity O(1)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
class Solution {
    public int trap(int[] height) {
        
        //the concept used is height of left side should be always greater than right side to hold the water
        //taking a pair of left pointers and right pointers, we can start checking if leftwall is greater than left or
        //rightwall is greater than right, if yes, then only we will be able to store water.
        
        if(height.length == 0){
            
            return 0;
        }
        int n = height.length;
        int left = 0;
        int leftWall = 0;
        int right = n - 1;
        int rightWall = n - 1;
        int result = 0;
        
        while(left <= right){
            
            if(height[leftWall] <= height[rightWall]){
               // System.out.println("left wall is"+ height[leftWall]);
              //  System.out.println("right wall is"+ height[rightWall]);
                
                if(height[left] < height[leftWall]){
                   // System.out.println("left");
                    result = result + height[leftWall] - height[left];
                    left ++;
                }
                else{
                    
                    leftWall = left;
                    left ++;
                }
            }
            else{
                
                 if(height[right] < height[rightWall]){
                    
                    result = result + height[rightWall] - height[right];
                    right --;
                }
                else{
                    
                    rightWall = right;
                    right --;
                }
                
                
            }
        }
        
        return result;
    }
}