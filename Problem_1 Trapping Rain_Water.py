# // Time Complexity : O(n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode :
# // Any problem you faced while coding this :
#
#
# // Your code here along with comments explaining your approach

class Solution:
    def trap(self, height: List[int]) -> int:
        if height == None or len(height) == 0:
            return 0
        n = len(height)
        lmax = 0
        rmax = 0
        left = 0
        right = n - 1
        result = 0
        while left < right:
            if height[left] <= height[right]:
                if lmax <= height[left]:
                    lmax = height[left]
                else:
                    result = result + lmax - height[left]
                left = left + 1
            else:
                if rmax <= height[right]:
                    rmax = height[right]
                else:
                    result = result + rmax - height[right]
                right = right - 1
        return result
