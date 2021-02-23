class TrappingRainWater {
  
    /*
      Time : O(N)
      Space : O(1)
      Leetcode : YES
      
    */
    
    /*
      Approach 
      1. Use four pointers : (leftWall, left) and (rightWall, right)
      2. process which side is less, leftWall or rightWall
      3. tap water inbetween leftWall and left, so always leftWall > height[left] and rightWall > height[right]
    */
    public int trap(int[] height) {
        if(height == null || height.length <=2 ) return 0;
        
        int leftWall = 0;
        int rightWall = 0;
        int left = 0;
        int right = height.length - 1;
        int result = 0;
        
        while(left <= right) {
            if(leftWall <= rightWall){
                
                if(leftWall < height[left]){
                    leftWall = height[left];
                }else{
                    result += leftWall - height[left];
                }
                left++;
            }else{
                
                if(rightWall < height[right]){
                    rightWall = height[right];
                }else{
                    result += rightWall - height[right];
                }
                
                right--;
            }
        }
        
        return result;
    }
}
