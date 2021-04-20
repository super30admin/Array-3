class TrappingRainWater {
    
    // Time Complexity: O(n)    (where n -> length of height array)
    // Space Complexity: O(1)
    
    public int trap(int[] height) {
        if(height == null || height.length == 0)
            return 0;
        
        int leftMax = 0;
        int rightMax = 0;
        
        int left = 0;
        int right = height.length - 1;
        
        int area = 0;
        
        while(left < right){
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            
            if(leftMax < rightMax){
                area = area + leftMax - height[left];
                left++;
            }else{
                area = area + rightMax - height[right];
                right--;
            }
        }
        
        return area;
    }
}