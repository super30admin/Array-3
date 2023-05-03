# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class Solution:
    def trap(self, height: List[int]) -> int:
        maxWall = 0
        m = 0
        count = 0
        for i in range(len(height)):
            if height[i] > maxWall:
                maxWall = height[i]
                m = i
        
        l = 0
        r = 0

        while r <= m:
            if height[r] < height[l]:
                count += (height[l] -height[r])
            else:
                l = r
            r += 1
        
        l = len(height) - 1
        r = len(height) - 1

        while l >= m:
            if height[l] < height[r]:
                count += (height[r] -height[l])
            else:
                r = l
            l -= 1
        return count
                
        

        
