# Time Complexity : O(n), n = length of height array
# Space Complexity : O(1), two-pointer approach
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# 1. Use two pointers from both ends of the array.
# 2. Keep track of the max height seen from left and right.
# 3. Water trapped at each position is determined by min(left_max, right_max) - height[i].
# 4. Move the pointer with smaller current height inward.

from typing import List

class Solution:
    def trap(self, height: List[int]) -> int:
        if not height:
            return 0
        left, right = 0, len(height) - 1
        left_max, right_max = height[left], height[right]
        water = 0
        while left < right:
            if left_max < right_max:
                left += 1
                left_max = max(left_max, height[left])
                water += max(0, left_max - height[left])
            else:
                right -= 1
                right_max = max(right_max, height[right])
                water += max(0, right_max - height[right])
        return water