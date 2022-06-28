using System;
namespace Algorithms
{
    public class TrappingRainWater
    {
        /// Time Complexity : O(N) 
        // Space Complexity :O(1) 
        // Did this code successfully run on Leetcode :Yes
        // Any problem you faced while coding this :  No 
        public int Trap(int[] height)
        {
            int left = 0;
            int right = height.Length - 1;
            int left_max = 0;
            int right_max = 0;
            int ans = 0;
            while (left < right)
            {
                if (height[left] < height[right])
                {
                    if (height[left] >= left_max)
                    {
                        left_max = height[left];
                    }
                    else
                    {
                        ans += left_max - height[left];
                    }
                    left++;
                }
                else
                {
                    if (height[right] >= right_max)
                    {
                        right_max = height[right];
                    }
                    else
                    {
                        ans += right_max - height[right];
                    }
                    right--;
                }
            }
            return ans;
        }
    }
}
