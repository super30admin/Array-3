// Time Complexity : Add : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class TrappingRainWater {
    public static void main(String[] args) {
        int [] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        trap(height);
    }

    public static int trap(int[] height) {


        int n = height.length;

        int result = 0;

        int leftWall = 0;
        int rightWall = 0;
        int left = 0;  // from the beginnning
        int right = n-1;  // from the end

        while(left <= right){   // T.C - O(N) ; S.C - O(1)
            if(leftWall <= rightWall){  // keep wall to calculate highest value towards left and right
                if(height[left] < leftWall){
                    result += (leftWall - height[left]) * 1; // 1 - width
                } else {
                    leftWall = height[left];  // if pointer height is greater than wall, assign wall to pointer
                }
                left++;
            } else {
                if(height[right] < rightWall){
                    result += (rightWall - height[right]) * 1; // 1 - width
                } else {
                    rightWall = height[right];
                }
                right--;
            }
        }

        return result;
    }
}

