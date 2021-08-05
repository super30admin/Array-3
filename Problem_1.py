from typing import List
class Solution:
    def trap(self, height: List[int]) -> int:
        if height == None or len(height) < 2:
            return 0
        result = 0
        lw = 0
        rw = 0
        l = 0
        r = len(height) -1
        while l <= r:
            if lw <= rw:
                if height[l] < lw:
                    result += lw - height[l]
                else:
                    lw = height[l]
                l += 1
            else:
                if height[r] < rw:
                    result += rw - height[r]
                else:
                    rw = height[r]
                r -= 1
        return result

# Time Complexity: O(n)
# Space Complexity: O(1)