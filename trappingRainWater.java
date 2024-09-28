// Time Complexity : O(n) where n is the length of the height array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 2 pointer approach. Initialize left and right as 0 and n-1 respectively and leftWall and rightWall as 0
// Now if leftWall < rightWall, we know that we can take the max height in the left side and if opposite, vice versa
// now if leftWall > current height of our left pointer, we can add the area to our answer which is the subtraction
// of leftWall height and current height. Same for case if leftWall > rightWall. We do this till our left and right
// pointers become meet.

class trappingRainWater {
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) return n;
        int ans = 0;
        int left = 0, right = n-1, leftWall = 0, rightWall = 0;
        while (left <= right) {
            if (leftWall < rightWall) {
                if (leftWall < height[left]) {
                    leftWall = height[left];
                } else {
                    ans += leftWall - height[left];
                }
                left++;
            } else {
                if (rightWall < height[right]) {
                    rightWall = height[right];
                } else {
                    ans += rightWall - height[right];
                }
                right--;    
            }
        }
        return ans;
    }
}