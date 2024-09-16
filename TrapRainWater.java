//Time Complexity: O(n)
//Space Complexity: O(1)

public class TrapRainWater {
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        int left = 0; int right = height.length - 1;
        int leftWall = 0, rightWall = 0;
        int amount = 0;
        while(left <= right){
            if(leftWall < rightWall){
                if(leftWall < height[left]){
                    leftWall = height[left];
                } else {
                    amount += leftWall - height[left];
                }
                left++;
            } else {
                if(rightWall < height[right]){
                    rightWall = height[right];
                } else {
                    amount += rightWall - height[right];
                }
                right--;
            }
        }
        return amount;
    }
}
