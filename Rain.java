// O(n) time: single iteration through array height
// O(1) space

class Solution {
    public int trap(int[] height) {
        int area = 0;
        int start = 0;
        int end = height.length - 1;
        int maxLeft = 0;
        int maxRight = 0;
        
        while (start < end){
            if (height[start] < height[end]){
                if (height[start] >= maxLeft){
                    maxLeft = height[start];
                }
                else{
                    area += maxLeft - height[start];
                }
                start++;
            }
            else{
                if (height[end] >= maxRight){
                    maxRight = height[end];
                }
                else{
                    area += maxRight - height[end];
                }
                end--;
            }
        }
        return area;
    }
