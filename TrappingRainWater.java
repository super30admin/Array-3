// 42.
// time - O(n)
// space - O(n)
class Solution {
    public int trap(int[] height) {
        //edge
        if(height == null || height.length == 0)
        {
            return 0;
        }
        int result = 0;
        int[] maxHeightInLeft = new int[height.length]; //each index tracks bar with largest height on left of current
        maxHeightInLeft[0] = 0; //there are no bars to the left of the very 1st bar
        for(int i = 1; i < height.length; i++)
        {
            //for each bar, max height in left is max among the max in left for prev bar and the height of prev bar
            maxHeightInLeft[i] = Math.max(maxHeightInLeft[i - 1], height[i - 1]);
        }
        
        int maxHeightInRight = 0; //there are no bars to the right of the last bar
        for(int i = height.length - 1; i >= 0; i--)
        {
            //the water amount over a bar is min(max height bar in left, max height bar in right) - height of current
            int currentBarValue = Math.min(maxHeightInRight, maxHeightInLeft[i]) - height[i];
            //add to result if current answer is +ve
            if(currentBarValue > 0)
            {
                result += currentBarValue;
            }
            //update max height bar in right which is max among its present value and height of current bar
            maxHeightInRight = Math.max(maxHeightInRight, height[i]);
        }
        return result;
    }
}
