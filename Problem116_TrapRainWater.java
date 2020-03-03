//2 Pointer Method
//Time Complexity: O(n) 

class Solution {
    public int trap(int[] height) {
        
        int left = 0, right = height.length-1;
        //left_max and right_max are the max bar on left and right side
        int left_max = 0, right_max = 0;
        int water_trap = 0;
        
        while(left < right){
            if(height[left] < height[right])
            {
                //case1:
                if(height[left] >= left_max){
                    left_max = height[left];
                } 
                //case2:
                else {
                    water_trap += (left_max - height[left]);
                }
                left++; //pointer moving forward
            } else{ 
                //case1:
                if(height[right]>=right_max){
                    right_max = height[right];
                }
                //case2:
                else {
                    water_trap += (right_max - height[right]);
                }
                right--;    //pointer moving towards right
            }
        }
        return water_trap;
    }
}