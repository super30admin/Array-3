# Formulae: Min(max_left, max_right) - curr_height
# One Approach is it takes extra memory : max_left, max_right(calculating this at every point)
# But this below approach uses 2 pointers and does this without any extra memory
class Solution:
    def trap(self, height: List[int]) -> int:
        l = 0
        r = len(height) - 1
        max_left = height[l]
        max_right = height[r]
        trapped_water = 0

        if len(height) == 0:
            return 0

        while l < r:

            if max_left < max_right:
                l += 1
                max_left = max(max_left, height[l])
                trapped_water += max_left - height[l]


            else:
                r -= 1
                max_right = max(max_right, height[r])
                trapped_water += max_right - height[r]

        return trapped_water





