// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// rain[i] = min(leftMax[i] - rightMax[i]) - height[i]; 
// calculate leftMax, rightMax and then check if rain can be trapped at that column

class Solution {
    public int trap(int[] height) {
        if(height==null || height.length<=2){
            return 0;
        }
        
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        
        //calculate leftMax
        int curMax = 0;
        for(int i=0; i<height.length; i++){
            leftMax[i] = curMax;
            curMax = Math.max(curMax, height[i]);
        }
    
        //calculate rightmax
        curMax = 0;
        for(int i=height.length-1; i>0; i--){
            rightMax[i] = curMax;
            curMax = Math.max(curMax, height[i]);
        }
        
        //rain[i] = min(leftMax[i], rightMax[i]) - height[i] if that is >0;
        int totalRain = 0;
        for(int i=0; i<height.length; i++){
            int rain = Math.min(leftMax[i], rightMax[i]) - height[i];
            if(rain>0){
                totalRain+=rain;
            }
        }
        
        return totalRain;
    }
}