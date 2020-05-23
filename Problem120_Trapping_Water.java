/**
 * Time Complexity - O(n)
 * Space Complexity - O(1)
 */

class Solution {
    public int trap(int[] height) {

        int left_max = 0, right_max =0;
        int left = 0, right = height.length-1;
        int result=0;

        while(left <= right){

            if(height[left] <= height[right]){

                if(height[left] >= left_max){
                    left_max = height[left];
                }else{
                    result += (left_max - height[left]);
                }
                left++;
            }else{

                if(height[right] >= right_max){
                    right_max = height[right];
                }else{
                    result += (right_max - height[right]);
                }
                right--;
            }

        }
        return result;

    }
}