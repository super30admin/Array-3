"""
Leetcode: https://leetcode.com/problems/trapping-rain-water/
Approach: Using 2 pointers
Time complexity: O(n). Single iteration of O(n).
Space complexity: O(1) extra space. Only constant space required for left, right, left_max and right_max.
"""


class Solution:
    def trap(self, height: List[int]) -> int:
        left = 0
        right = len(height) - 1

        # Base case
        if len(height) == 0:
            return 0

        leftMax = 0
        rightMax = 0
        count = 0

        while left < right:
            leftMax = max(leftMax, height[left])
            rightMax = max(rightMax, height[right])

            if leftMax < rightMax:
                count += (leftMax - height[left])
                left += 1
            else:
                count += (rightMax - height[right])
                right -= 1
        return count