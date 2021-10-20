// Time Complexity: O(n)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int trap(int[] height) {
        int leftWall = 0, rightWall = 0;
        int left = 0, right = height.length -1;
        int result = 0;
        while(left <= right) {
            if(leftWall <= rightWall) {
                if(leftWall >= height[left]) {
                    result += leftWall - height[left];
                    left++;
                } else {
                    leftWall = height[left];
                }
            } else {
                if(rightWall >= height[right]) {
                    result += rightWall - height[right];
                    right--;
                } else {
                    rightWall = height[right];
                }
            }
        }
        return result;
    }
}