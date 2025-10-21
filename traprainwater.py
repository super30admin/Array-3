# Time Complexity : O(N) where N is the length of the array
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:
# I am using two pointer approach to solve this problem.
# The two pointers are initialized at the start and end of the height array.
# I am also initializing two variables lw and rw to keep track of the maximum height of the left and right walls.
# I am iterating through the height array until the left pointer is less than the right pointer.
# If the left wall is smaller than the right wall, I move the left pointer to the right and update the left wall height.
# I calculate the water trapped at the current left position by subtracting the height at that position from the left wall height.
# If the right wall is smaller than or equal to the left wall, I move the right pointer to the left and update the right wall height.
# I calculate the water trapped at the current right position by subtracting the height at that position from the right wall height.
# Finally, I return the total water trapped.    

from typing import List
class Solution:
    def trap(self, height: List[int]) -> int:
        n = len(height)
        left = 0
        right = n - 1
        lw = height[left]
        rw = height[right]
        result = 0
        while left < right:
            if lw < rw:
                left += 1
                lw = max(lw,height[left])
                result += lw  - height[left]
            else:
                right -= 1
                rw = max(rw,height[right])
                result += rw  - height[right]
        return result