# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        
        l, h = 0, len(height) - 1
        
        lmax, rmax = height[l], height[h]
        ans = 0
        
        while l < h:
            if lmax < rmax:
                l += 1
                lmax = max(lmax, height[l])
                ans += lmax - height[l]
            else:
                h -= 1
                rmax = max(rmax, height[h])
                ans += rmax - height[h]
        return ans