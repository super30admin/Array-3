# Did this code successfully run on Leetcode : YES

# TC: O(N)
# SC: O(1)

class Solution:
    def trap(self, height: List[int]) -> int:
        n = len(height)
        lw, rw = 0, 0
        l, r = 0, n-1
        res = 0
        while l <= r:
            if lw <= rw:
                # left
                if height[l] < lw:
                    res += lw - height[l]
                else:
                    lw = height[l]
                l += 1
            else:
                # right
                if height[r] < rw:
                    res += rw - height[r]
                else:
                    rw = height[r]
                r -= 1
        return res