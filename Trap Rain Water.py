# time complexity :- O(n)
# Space complexity: - O(1)
class Solution:
    def trap(self, height: List[int]) -> int:
        lmax = float('-inf')
        rmax = float('-inf')
        left = 0
        water = 0
        right = len(height) - 1
        if (height[0] > lmax):
            lmax = height[0]

        if (height[-1] > rmax):
            rmax = height[-1]

        while (left < right):

            if height[left] > lmax:
                lmax = height[left]

            if height[right] > rmax:
                rmax = height[right]

            if lmax < rmax:
                water += (lmax - height[left])
                left += 1

            else:
                water += (rmax - height[right])
                right -= 1

        return water
