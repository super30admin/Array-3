// TC - O(n), SC - O(1)

// LC - 42

class Solution {
    public int trap(int[] height) {
		// sanity check
        if(height == null || height.length == 0){
            return 0;
        }
        
        int leftMax = 0;
        int rightMax = 0;
        
        int left = 0, right = height.length - 1;
        
        int area = 0;
        // While loop 
        while(left < right){
			// calculating leftMax and rightMax
            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);
            // calculating area
            if(leftMax < rightMax){
                area = area + (leftMax - height[left]);
                left++;
            }else{
                area = area + (rightMax - height[right]);
                right--;
            }
        }
        return area;
    }   
}