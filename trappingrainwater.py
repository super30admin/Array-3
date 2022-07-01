#Time Complexity: O(n)
#Space Complexity: O(1)
class Solution:
    def trap(self, height: List[int]) -> int:
        n = len(height)
        leftWall = height[0]
        rightWall = height[n-1]
        l = 0
        r = n-1
        count = 0
        while l<=r:
            if leftWall <= rightWall:
                if leftWall >= height[l]:
                    count += leftWall - height[l]
                else:
                    leftWall = height[l]
                l += 1
                
            else:
                if rightWall >= height[r]:
                    count += rightWall - height[r]
                    
                else:
                    rightWall = height[r]
                r -= 1
                
        return count
                    
                    
                    
        