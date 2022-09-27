#Time Complexity: O(n)
#Space Complexity: O(1)

class Solution:
    def trap(self, height: List[int]) -> int:
        left = 0
        right = len(height)-1
        
        leftWall = 0
        rightWall = 0
        
        ans = 0
        
        while(left < right):
            
            if height[left] < height[right]: # WHich side to process. IF height at left is smaller, process left 
                
                if height[left] >= leftWall: # If current height at left is more than leftwall update current as left wall
                    leftWall = height[left]
                else:
                    ans += leftWall - height[left] # IF curr height at left is smaller, add leftWall - current height to answer
                left += 1
                
            else: # If height at right is greater or equal to left then process right
                if height[right] >= rightWall:
                    rightWall = height[right] # If current height at right is more than rightWall update current as right wall
                else:
                    ans += rightWall - height[right] # IF curr height at right is smaller, add rightWall - current height to answer
                right -= 1
            
        return ans
            