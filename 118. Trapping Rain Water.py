class Solution:
    def trap(self, height: List[int]) -> int:
        if len(height) == 0 or height is None:
            return
        lw, rw = 0, 0
        l, r = 0, len(height) - 1
        result = 0

        while l < r:
            if lw <= rw:
                if lw > height[l]:
                    result += lw - height[l]
                else:
                    lw = height[l]
                l += 1
            else:
                if rw > height[r]
                    result += rw - height[r]
                else:
                    rw = height[r]
                r -= 1
        return result


# TC = O(N)
# Space complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : Syntax errors and accidentally assigned l and r pointer as heights and lw and rw as index(pointers)


