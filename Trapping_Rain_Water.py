# Time Complexity : O(N), where N is the length of the height list
# Space Complexity : O(N) 
from typing import List

class Solution:
    def trap(self, height: List[int]) -> int:
        if not height:
            return 0

        n = len(height)
        left = [0] * n
        right = [0] * n
        left[0] = height[0]
        right[n-1] = height[n-1]

        # Calculate the maximum height from the left side up to each index
        for i in range(1, n):
            left[i] = max(left[i-1], height[i])

        # Calculate the maximum height from the right side up to each index
        for i in range(n-2, -1, -1):
            right[i] = max(right[i+1], height[i])

        total_water = 0

        # Calculate the trapped water at each index
        for i in range(n):
            water_level = min(left[i], right[i])
            trapped_water = water_level - height[i]
            total_water += trapped_water

        return total_water