"""
Time Complexity : O(n) where n is number of elements of the height list
Space Complexity : O(1) as no auxillary data structure is used

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Approach:
Water can be trap only if the building with greater height is present in the forward direction from the current point.
Hence, take two pointers lWall and rWall to determine if there is a building with greater height present as we traverse in the given direction.
Once, it is sure that there is building with greater height is present, then on the given side, determine if water can be trap, for this take another two pointers l and r.
"""


class Solution:
    def trap(self, height: List[int]) -> int:
        if len(height) == 0:
            return 0
        area = 0
        lw = 0
        rw = 0
        l = 0
        r = len(height) - 1

        while l <= r:
            if lw <= rw:
                if lw > height[l]:
                    area += (lw-height[l])
                else:
                    lw = height[l]
                l += 1
            else:
                if rw > height[r]:
                    area += (rw-height[r])
                else:
                    rw = height[r]
                r -= 1

        return area
