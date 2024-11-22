# 42. Trapping Rain Water
class Solution:
    def trap(self, height: List[int]) -> int:
        n = len(height)
        result = 0

        lw,l = 0,0
        rw, r = n-1, n-1

        while l <= r:
            if height[rw] >= height[lw]:
                if height[lw] <= height[l]:
                    lw = l
                else:
                    result += height[lw] - height[l]
                l += 1
            elif height[lw] > height[rw]:
                if height[rw] <= height[r]:
                    rw = r
                else:
                    result += height[rw] - height[r]
                r -= 1

        return result
