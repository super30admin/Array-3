/***
 Using 2 pointers approach
 TC - O(n)
 SC - O(1)
 */
class TrapRainWater {
    public int trap(int[] height) {

        int left =0;
        int right = height.length-1;
        int leftMax = height[0];
        int rightMax = height[right];
        int result =0;

        while(left < right) {
            if(leftMax <= rightMax) {
                left++;
                //process left side because leftmax - height[left] is the max water we can store at that index
                if(leftMax > height[left]) {
                    result += leftMax - height[left];
                }

                else {
                    leftMax = height[left]; // keep track of max height at left
                }
            }

            else {
                //process right side
                right--;
                if(rightMax > height[right]) {
                    result += rightMax - height[right];
                }

                else {
                    rightMax = height[right]; //keep track of max height at right
                }
            }
        }

        return result;

    }
}