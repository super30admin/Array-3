// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope.

class TrappingRainWater {
    public int trap(int[] height) {
        int result = 0;
        if(null == height || 0 == height.length){return 0;}
        int size = height.length;
        int[] leftMax = new int[size];
        int[] rightMax = new int[size];
        leftMax[0] = height[0];
        for(int i = 1; i < size; i++){
            leftMax[i] = Math.max(height[i],leftMax[i-1]);
        }
        rightMax[size-1] = height[size-1];
        for(int i = size - 2; i >= 0; i--){
            rightMax[i] = Math.max(height[i],rightMax[i+1]);
        }
        for(int i = 1; i < size - 1; i ++){
            result += Math.min(leftMax[i],rightMax[i]) - height[i];
        }
    return result;
    }
}