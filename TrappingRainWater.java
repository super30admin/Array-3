//time complexity : O(n) n = number of buildings
//space complexity : O(1)

class Solution {
    public int trap(int[] height) {

        int n = height.length;
        int indexOfMaxBuilding = 0;
        int maxBuilding = Integer.MIN_VALUE;

        for(int i=0; i<n; i++) {
            if(height[i] > maxBuilding)
            {
                maxBuilding = height[i];
                indexOfMaxBuilding = i;
            }
        }

        int water=0;

        int leftMax = Integer.MIN_VALUE;
        for(int i=0; i<indexOfMaxBuilding; i++) {
            if(height[i] > leftMax)
            {
                leftMax = height[i];

            }
            water += leftMax - height[i];
        }

        int rightMax = Integer.MIN_VALUE;
        for(int i=n-1; i>indexOfMaxBuilding; i--)
        {
            if(height[i] > rightMax)
            {
                rightMax = height[i];
            }
            water += rightMax - height[i];
        }

        return water;

    }
}
