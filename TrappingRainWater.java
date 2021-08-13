package Array3;

public class TrappingRainWater {
    /* Created by palak on 8/12/2021 */

    /**
     Time Complexity: O(n)
     Space Complexity: O(1)
     */
    public int trap(int[] height) {
        int totalWaterTrapped = 0;
        int[] left = new int[height.length];
        int[] right = new int[height.length];

        if(height.length == 0 || height == null)    return 0;
        left[0] = height[0];
        for(int i = 1 ; i < height.length ; i++) {
            left[i] = Math.max(height[i], left[i-1]);
        }
        right[height.length - 1] = height[height.length - 1];
        for(int i = height.length - 2 ; i >= 0 ; i--) {
            right[i] = Math.max(height[i], right[i+1]);
        }

        for(int i = 1; i < height.length - 1 ; i++) {
            totalWaterTrapped += Math.min(left[i], right[i]) - height[i];
        }
        return totalWaterTrapped;
    }


    /**
     Using 4 pointers
     Time Complexity: O(n)
     Space Complexity: O(1)
     */
    public int trapPointers(int[] height) {
        if(height == null || height.length < 2)   return 0;
        int left = 0;   //index
        int right = height.length - 1;  //index
        int leftWall = 0;  //height of left wall
        int rightWall = 0;  //height of right wall
        int totalWater = 0;

        while(left <= right) {
            if(leftWall <= rightWall) {
                //Left side moves ahead
                if(height[left] < leftWall) {
                    // Can trap water now
                    totalWater += leftWall - height[left];
                } else {
                    leftWall = height[left];
                }
                left++;
            } else {
                //Right side moves ahead
                if(height[right] < rightWall) {
                    // Can trap water now
                    totalWater += rightWall - height[right];
                } else {
                    rightWall = height[right];
                }
                right--;
            }
        }
        return totalWater;
    }

    public static void main(String[] args) {

    }
}
