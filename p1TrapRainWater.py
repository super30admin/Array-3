#Time: O(N)
#space: O(1)

class Solution:
    def trap(self, height: List[int]) -> int:
        """
        min(max leftWall, max rightWall) - height[curr]
        
        """
        
        l, r  = 0, len(height)-1
        leftWall, rightWall= height[l], height[r]
        ans = 0
        
        while l < r:
            if leftWall < rightWall:
                l += 1
                leftWall = max (leftWall ,height[l])
                ans += leftWall - height[l]
            else:
                r -= 1
                rightWall = max(rightWall, height[r])
                ans += rightWall - height[r]
        return ans