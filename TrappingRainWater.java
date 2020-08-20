//Time - O(n)
//Space - O(1)

class Solution {
    public int trap(int[] height) {
        
        int left_max=0;
        int right_max = 0;
        int left = 0;
        int right = height.length-1;
        int rain = 0;
        while(left<right)
        {
            if(height[left]<height[right])
            {
                if(height[left]>=left_max)
                {
                    left_max = height[left];
                    left++;
                }
                else
                {
                    rain = rain + left_max - height[left];
                    left++;
                }
            }
            else if(height[left]>=height[right])
            {
                if(height[right]>=right_max)
                {
                    right_max = height[right];
                    right--;
                }
                else
                {
                    rain = rain + right_max - height[right];
                    right--;
                }
            }
        }
        return rain;
    }
}
