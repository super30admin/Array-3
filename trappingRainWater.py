"""
Approach --
- Use 4 pointers - lw, l, rw, r
l = 0, lw = 0, rw = 0, r = width of the entire horizontal
- If lw == rw, process lw
- if lw < l, then lw = h[l] else rtnData = lw - h[l]
- Similarly, if rw < r, then rw = h[r] else rtnData = rw - h[r]
- Return rtnData

TC - O(n)
SC - O(1)
"""

class Solution:
    def trap(self, height: List[int]) -> int:
        if height is None or len(height) == 0: return 0
        rtnData = 0
        n = len(height)
        l = 0
        lw = 0
        rw = 0
        r = n-1

        while l <= r:
            if lw <= rw:
                if height[l] < lw:
                    rtnData = rtnData + lw - height[l]
                else:
                    lw = height[l]
                l += 1
            else:
                if height[r] < rw:
                    rtnData = rtnData + rw - height[r]
                else:
                    rw = height[r]
                r -= 1
        return rtnData