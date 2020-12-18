"""
Time Complexity : O(n) for traversing
Space Complexity : O(1) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
This is a 2 pointer approach. We are taking left, right, left wall and right wall. A water can only be trapped
between 2 walls, we will be traversing that side which has smaller wall. So, if left pointer is on a position
which is lower than the left wall, we can store water there. If not, we cannot. So we move the wall and left
pointer. Same with right and right wall. We do this until l<=r.
"""


class Solution:
    def trap(self, height: List[int]) -> int:
        if not height:
            return 0
        length = len(height)-1
        l = 0
        r = length
        lw = height[l]
        rw = height[r]
        water = 0
        while l <= r:
            if lw <= rw:
                if height[l] < lw:
                    water += (lw-height[l])
                else:
                    lw = height[l]
                l += 1
            else:
                if height[r] < rw:
                    water += (rw-height[r])
                else:
                    rw = height[r]
                r -= 1
        return water
