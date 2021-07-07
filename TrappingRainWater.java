//TC : O(n) ,  n length of array
//Sc : O(1)
class Solution {
    public int trap(int[] height) {
        if(height.length == 0 || height == null)
            return 0;
        
        int leftWall=0,rightWall =0;
        
        int left=0,right=height.length-1;
        int amount=0;
        
        while(left<=right){
            //Start with the shorter wall
            
            if(leftWall < rightWall){
                //Store water if wall is higher
                if(leftWall > height[left]){
                    amount += leftWall - height[left];
                }
                //Move the wall
                else{
                    leftWall = height[left];
                }
                left++;
            }
            else{
                
                 if(rightWall > height[right]){
                    amount += rightWall - height[right];
                }
                else{
                    rightWall = height[right];
                }
                right--;
            }            
        }
        
        return amount;
    }
}