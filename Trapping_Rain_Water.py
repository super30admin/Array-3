# Explain your approach briefly at the top:
# To calculate trapped water at each position, determine the maximum height of bars to the left and right.
# The water trapped at a position is the minimum of these two heights minus the height of the bar at that position.
# This can be optimized using two pointers to avoid storing the maximum heights explicitly.

# Time Complexity: O(n), where n is the length of the height array.
# Space Complexity: O(1), as we are using only pointers and variables for computation.
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

from typing import List

class Solution:
    def trap(self, height: List[int]) -> int:
        # Edge case: If the length of height is less than 3, no water can be trapped
        if len(height) < 3:
            return 0

        left, right = 0, len(height) - 1  # Two pointers
        left_max, right_max = 0, 0  # To store the max heights on the left and right
        trapped_water = 0  # To accumulate the total trapped water

        # Traverse the array using two pointers
        while left < right:
            if height[left] < height[right]:
                # If height[left] is less, calculate water trapped at left
                if height[left] >= left_max:
                    left_max = height[left]  # Update left_max
                else:
                    trapped_water += left_max - height[left]  # Add trapped water
                left += 1  # Move left pointer
            else:
                # If height[right] is less, calculate water trapped at right
                if height[right] >= right_max:
                    right_max = height[right]  # Update right_max
                else:
                    trapped_water += right_max - height[right]  # Add trapped water
                right -= 1  # Move right pointer

        return trapped_water
