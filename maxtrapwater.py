class Solution:
    def trap(self, height: List[int]) -> int:
        if height is None or len(height) == 0: return 0
        result = 0
        lw, rw, l, r = 0, 0, 0, len(height) - 1

        while l <= r:
            if lw <= rw:
                if lw > height[l]:
                    result += 1 * (lw - height[l])
                else:
                    lw = height[l]
                l += 1
            else:
                if rw > height[r]:
                    result += 1 * (rw - height[r])
                else:
                    rw = height[r]
                r -= 1
        return result



