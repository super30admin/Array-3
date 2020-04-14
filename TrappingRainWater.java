Time Complexity = O(n)
Space Complexity = O(1)

class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        
        leftMax[0] = 0;
        for(int i=1; i < n; i++){
            leftMax[i] = Math.max(leftMax[i-1],height[i-1]);
        }
        
        rightMax[n-1] = 0;
        for(int i = n-2; i >=0;i--){
            rightMax[i] = Math.max(rightMax[i+1],height[i+1]);
        }
        
        int totalWater = 0;
        for(int i = 0; i< n; i++){
            int currentWater = Math.min(leftMax[i],rightMax[i]) - height[i];
            if(currentWater < 0){
                currentWater = 0;
            }
                totalWater+= currentWater;
        }
        return totalWater;
    }
}