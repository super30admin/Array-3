"""
4 pointers approach practice -
TC - O(n)
SC = O(1)

1. when lw <== rw: process left
2. else: process right
3. while processing left --> if lw > height[l]: append lw-height[l] to rtnData else: assign height[l] to lw. at the end l += 1
4. while processing right --> if rw > height[r]: append rw-height[r] to rtnData else: assign height[r] to rw. at the end r -= 1
"""


class Solution:
    def trap(self, height: List[int]) -> int:
        if height is None or len(height) == 0: return 0

        n = len(height)

        # 4 pointers
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