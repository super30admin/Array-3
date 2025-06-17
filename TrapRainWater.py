"""
TC - O(n)
SC = O(1)
"""


class Solution:
    def trap(self, height: List[int]) -> int:
        if height is None or len(height) == 0: return 0

        n = len(height)

        l = 0
        lw = 0
        r = n - 1
        rw = 0

        rtnData = 0

        while l <= r:
            if lw <= rw:
                if lw > height[l]:
                    rtnData += lw - height[l]
                else:
                    lw = height[l]
                l += 1
            else:
                if rw > height[r]:
                    rtnData += rw - height[r]
                else:
                    rw = height[r]
                r -= 1

        return rtnData