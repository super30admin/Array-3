//Time complexity: O(N), where N is the length of the height array.
//Space complexity: O(1)

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        
        int leftWall = 0;
        int rightWall = 0;
        int left = 0;
        int right = n-1;
        
        int water = 0;
        
        while(left<right) {
            if(height[left] <= height[right]) {
                if(leftWall < height[left]) {
                    leftWall = height[left];
                } else {
                    water += (leftWall - height[left]);;
                }
                left++;
            } else {
                 if(rightWall < height[right]) {
                    rightWall = height[right];
                } else {
                    water += (rightWall - height[right]);
                }
                right--;
            } 
        }
        
        return water; 
    }
}