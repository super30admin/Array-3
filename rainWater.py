#Time Complexity: O(N)
#Space Complexity: O(1)
#Run on Leetcode: Yes
#Any Issues: No

class Solution:
    def trap(self, height: List[int]) -> int:
        n = len(height)
        lWall = rWall = 0
        l = 0
        r = n-1
        result = 0
        
        while (l <= r):
            if (lWall <= rWall):
                if(height[l] < lWall):
                    result += lWall - height[l]
                else:
                    lWall = height[l]
                
                l += 1
            else:
                if(height[r] < rWall):
                    result += rWall - height[r]
                else:
                    rWall = height[r]
                
                r -= 1
        return result
                    
        