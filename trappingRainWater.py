class Solution:
    def trap(self, height: List[int]) -> int:
        if height is None or len(height) == 0:
            return 0
        n = len(height)
        lmax, rmax = 0, 0
        left = 0
        right = n - 1
        res = 0
        while left < right:
            if height[left] <= height[right]:
                if lmax <= height[left]:
                    lmax = height[left]
                else:
                    res += lmax - height[left]
                left += 1
            else:
                if rmax <= height[right]:
                    rmax = height[right]
                else:
                    res += rmax - height[right]
                right -= 1
        return res
