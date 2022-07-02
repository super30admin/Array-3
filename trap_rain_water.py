# Time Complexity : O(N) where n is number of elements in the heights array
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def trap(self, height: List[int]) -> int:
        tpoint = 0
        n = len(height)
        water = 0
        for i in range(1, n):
            if height[tpoint] < height[i]:
                tpoint = i
        
        lwall = 0
        for left in range(0, tpoint+1):
            if height[left] <= height[lwall]:
                water += height[lwall] - height[left]
            else:
                lwall = left
        
        rwall = n-1
        for right in range(n-1, tpoint-1, -1):
            if height[right] <= height[rwall]:
                water += height[rwall] - height[right]
            else:
                rwall = right
                
        return water