# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using two pointers and left wall and right wall
# While left <= right, if lw <= rw and check height of left is less than lw then the water can be trapped else set lw to height of left
# Increment left by 1
# Else if height of right is less than rw then again the water can be trapped else set rw to height to right
# Decrement right pointer by 1
# Return res


class Solution:
    def trap(self, height: List[int]) -> int:
        if not height:
            return 0

        left = 0
        right = len(height) - 1
        lw = 0
        rw = 0
        res = 0
        while left <= right:
            if lw <= rw:
                if height[left] < lw:
                    res += lw - height[left]
                else:

                    lw = height[left]
                left += 1
            else:
                if height[right] < rw:
                    res += rw - height[right]
                else:

                    rw = height[right]

                right -= 1
        return res