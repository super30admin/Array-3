class Solution {
    public int trap(int[] height) {
        //base case
        if(height == null || height.length == 0){
            return 0;
        }
        
        int max = 0;
        int[] leftmax = new int[height.length];
        //calculating left max
        for(int i = 0; i < height.length; i++){
            leftmax[i] = Math.max(max, height[i]);
            max = leftmax[i];
        }
        
        max = 0;
        int area = 0;
        //calculating right max and area
        for(int i = height.length - 1; i >= 0; i--){
            max = Math.max(max, height[i]);
            area += Math.min(leftmax[i], max) - height[i];
        }

        return area;
    }
}

// Time Complexity: O(2n)
// Space Complexity: O(n)
