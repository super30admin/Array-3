# // Time Complexity : O(n)
# // Space Complexity : o(1)
# // Did this code successfully run on Leetcode : Yes

class Solution:
    def trap(self, height: List[int]) -> int:
        if height is None or len(height) == 0:
            return None

        lw = 0
        rw = 0

        l = 0
        r = len(height) - 1
        result = 0

        while l <= r:
            if lw <= rw:
                if height[l] < lw:
                    result = result + lw - height[l]
                else:
                    lw = height[l]
                l += 1

            else:
                if height[r] < rw:
                    result = result + rw - height[r]
                else:
                    rw = height[r]
                r -= 1

        return result

