class Solution:
    # Time Complexity - O(n)
    # Space Complexity - O(1)
    # 2 pointer approach
    def trap(self, height) -> int:
        if height == 0 or len(height) == 0: return 0
        lw, rw = 0, 0
        l, r = 0, len(height) - 1

        result = 0

        while l <= r:
            if lw <= rw:
                if (lw > height[l]):
                    result += lw - height[l]
                else:
                    lw = height[l]

                l += 1

            else:
                if rw > height[r]:
                    result += rw - height[r]
                else:
                    rw = height[r]

                r -= 1

        return result
