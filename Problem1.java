/*
    LC - 42. Trapping Rain Water
    TC - O(n) + O(n) + O(n) ~ O(3n)
    SC - O(2n) for left and right ~ O(n)
*/

class Solution {
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        int result = 0;

        int leftMax = height[0];
        for(int i=0; i<height.length; i++) {
            left[i]=Math.max(height[i], leftMax);
            leftMax = left[i];
        }

        int rightMax = height[height.length-1];
        for(int i=height.length-1; i>=0; i--) {
            right[i] = Math.max(height[i], rightMax);
            rightMax = right[i];
        }

        for(int i=0; i<height.length; i++) {
            result = result + Math.min(left[i], right[i]) - height[i];
        }

        return result;
    }
}