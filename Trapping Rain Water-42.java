// Time Complexity: O(n)
//Space Complexity: O(1)
class Solution {
    public int trap(int[] height) {

         if(height == null || height.length == 0){
            return 0;
        }

        int leftW = 0;
        int rightW = 0;
        int left = 0;
        int right = height.length - 1;
        int total = 0;

        while(left <= right){
            if(leftW <= rightW){
                if(leftW >= height[left]){
                    total = total + (leftW - height[left]);
                }
                else{
                    leftW = height[left];
                }
                left++;
            }
            else {
                if(rightW >= height[right]){
                    total = total + (rightW - height[right]);
                }
                else{
                    rightW = height[right];
                }
                right--;
            }
        }
        return total;
    }
}
