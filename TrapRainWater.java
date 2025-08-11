//time complexity- O(n) where n is array length
//space complexity- O(1)
public class TrapRainWater {
    static int trap(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n - 1;

        int leftMax = 0;
        int rightMax = 0;
        int sum = 0;

        while(left < right) {
            if(height[left] <= height[right]) {
                if(leftMax > height[left]) {
                    sum += leftMax - height[left];
                } else {
                    leftMax = Math.max(leftMax, height[left]);
                }
                left++;
            } else {
                if(rightMax > height[right]) {
                    sum += rightMax - height[right];
                } else {
                    rightMax = Math.max(rightMax, height[right]);
                }
                right--;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("Maximum water that can be stored is " + trap(height));
    }
}
