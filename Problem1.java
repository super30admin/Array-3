
//Time Complexity - O(n)
//Space Complexity - O(1)

class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0, totalTrappedWater = 0;

        while(left < right)
            if(height[left] < height[right])
                if(height[left] >= leftMax)
                    leftMax = height[left++];
                else
                    totalTrappedWater += (leftMax - height[left++]); 
            else
                if(height[right] >= rightMax)
                    rightMax = height[right--];
                else
                    totalTrappedWater += (rightMax - height[right--]);

        return totalTrappedWater;
    }
}

