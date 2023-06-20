# Time Complexity: O(n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
The idea is to use two pointers left and right. We will keep track of left_max and right_max. When left is lesser than right, 
it means that the water might spill on the left side. So we will check if the left_max is greater than the current height. 
If it is, it means that that is the maximum capacity that it can hold. 
"""

class Solution:
    def trap(self, height: list[int]) -> int:
        if not height: return 0

        left, right = 0, len(height) - 1
        ans = 0
        left_max, right_max = 0, 0
        while left < right:
            if height[left] < height[right]:
                if height[left] >= left_max:
                    left_max = height[left]
                else:
                    ans += (left_max - height[left])
                left += 1
            else:
                if height[right] >= right_max:
                    right_max = height[right]
                else:
                    ans += (right_max - height[right])
                right -= 1

        return ans
