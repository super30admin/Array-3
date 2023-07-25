// TC = O(n), SC = O(1)
class Solution {
    public int trap(int[] height) {
        int max = 0;
        int maxIdx = 0;
        int result = 0;
        int n = height.length;
        int left = 0;
        int right = n-1;
        // Finding the max Index
        for(int i=0;i<height.length;i++){
            if(max<height[i]){
                max = height[i];
                maxIdx = i;
            }
        }
        // Iterating from left to maxIdx using 2 pointers
        for(int i=0;i<=maxIdx;i++){
            if(height[left]<=height[i]){
                left = i;
            }else{
                result = result + height[left] - height[i];
            }
        }
        // Iterating from right to maxIdx using 2 pointers
        for(int i=n-1;i>=maxIdx;i--){
            if(height[right]<=height[i]){
                right = i;
            }else{
                result = result + height[right] - height[i];
            }
        }

        return result;
    }
}