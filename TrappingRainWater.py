# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : We use two pointers from both ends and keep track of the tallest walls on each side.
# At each step, we process the side with the smaller wall since that determines water trapping.
# We add trapped water if current height is less than the known max wall on that side.

class Solution:
    def trap(self, height: List[int]) -> int:
        left, right = 0, len(height) - 1
        ans = 0
        left_max, right_max = height[left], height[right]

        while left < right:
            if left_max < right_max:
                left += 1
                left_max = max(left_max, height[left])
                ans += left_max - height[left]
            else:
                right -= 1
                right_max = max(right_max, height[right])
                ans += right_max - height[right]
        
        return ans

        