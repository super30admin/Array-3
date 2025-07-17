// Time complexity - O(n)
// Space complexity - O(1)
// Solved on leetcode - Yes
// faced any issues - No
// At every index get the Min of leftMax and rightMax and subtract with current height- this gives the number of units of water that can be stored at that index;
class Solution {
    public int trap(int[] height) {
        int leftMax = 0, rightMax = 0, water =0;
        for(int i=0;i<height.length;i++) {
            rightMax = height[rightMax] > height[i] ? rightMax : i;
        }

        for(int i=0;i<rightMax;i++) {
            leftMax = height[leftMax]>height[i] ? leftMax : i;
            water = water + Math.min(height[leftMax], height[rightMax]) - height[i];
        }
        leftMax = rightMax;
        rightMax = height.length-1;
        for(int i=rightMax;i>leftMax;i--) {
            rightMax = height[rightMax] > height[i] ? rightMax : i;
            water = water + Math.min(height[leftMax], height[rightMax]) - height[i];
        }
        return water;
    }
}
