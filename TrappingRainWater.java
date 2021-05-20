// Approach - Two Pointer approach
// Time Complexity - O(N) - N is the length of height
// Space Complexity - O(1)

class Solution {
  public int trap(int[] height) {

    int leftMax = 0, rightMax = 0;
    int left = 0, right = height.length-1;

    int result = 0;

    while(left <= right){
      if(height[left] <= height[right]){
        if(leftMax <= height[left]){
          leftMax = height[left];
        }else{
          result += (leftMax - height[left]);
        }
        left++;
      }
      else{
        if(rightMax <= height[right]){
          rightMax = height[right];
        }else{
          result += (rightMax - height[right]);
        }
        right--;
      }
    }
    return result;
  }
}
