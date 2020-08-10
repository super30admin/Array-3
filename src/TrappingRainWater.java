// Time Complexity : o(n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english - 


//https://leetcode.com/problems/trapping-rain-water/
class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        
        int n = height.length, result = 0;
        int left =0, right = n-1;
        
        //left and right wall heights
        int lw = 0, rw = 0;
        
        while(left <= right){
            
            //checking this ensures that when we process left side, there is a wall equal or bigger that lw on right side which will allow water to be trapped between lw and height[current left]
            if(lw <= rw) { //if left wall is less than equal to right wall, process left side
                if(lw > height[left]){
                    result+= (lw - height[left]); //if left wall is greater than current left, water can be trapped
                    
                }else {
                    lw = height[left]; //else change left wall height to current left 
                }
                left++;
            }else { //process right side
                 if(rw > height[right]){
                    result+= (rw - height[right]);
                    
                }else {
                    rw = height[right];
                }
                right--;
            }
        }
        
        return result;
    }
}