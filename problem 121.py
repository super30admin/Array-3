#   https://leetcode.com/problems/trapping-rain-water/


class Solution:
    def trap(self, height: List[int]) -> int:
        lmax = 0
        rmax = 0
        total_water = 0

        l = 0
        r = len(height) - 1
        while(l<r):
            if height[l] <= height[r]:
                if lmax > height[l]:
                    total_water += lmax - height[l]
                else:
                    lmax = height[l]
                l+=1
            else:
                if rmax > height[r]:
                    total_water += rmax - height[r]
                else:
                    rmax = height[r]
                r-=1
        
        return total_water

# TC: O(n)
# SC: O(1)