# The trap method calculates the amount of water trapped after raining, given elevation heights.

# Use two pointers (l and r) and track the maximum heights on the left and right:
# - Move the pointer with the smaller max height.
# - Update the max height for that side and calculate trapped water at the current pointer.

# Repeat until the two pointers meet, accumulating the trapped water.

# TC: O(n) - Single traversal of the height array.
# SC: O(1) - Constant space usage.


from typing import List


class Solution:
    def trap(self, height: List[int]) -> int:
        if not height:
            return 0

        l, r = 0, len(height) - 1
        leftMax, rightMax = height[l], height[r]
        res = 0
        while l < r:
            if leftMax < rightMax:
                l += 1
                leftMax = max(leftMax, height[l])
                res += leftMax - height[l]
            else:
                r -= 1
                rightMax = max(rightMax, height[r])
                res += rightMax - height[r]
        return res