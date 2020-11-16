# TC: O(N)
# SC: O(1)
# Yes, It ran on Leetcode
# No problems

class Solution:
    def trap(self, height) -> int:
        
        l = 0
        r = len(height)-1
        water = 0
        lmax = 0
        rmax = 0
        
        while l<r:
            if height[l]<height[r]:
                lmax = max(lmax,height[l])
                water += lmax-height[l]
                l += 1
            else:
                rmax = max(rmax,height[r])
                water += rmax-height[r]
                r -= 1
        return water