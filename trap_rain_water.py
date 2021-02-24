# Approach - using 2 pointers and sliding window trap water using walls and current heights
# Time - O(N)
# Space - O(1)
class Solution:
    def trap(self, height: List[int]) -> int:
        
        if not height or len(height) == 0:
            return 0
        
        left_wall, right_wall = 0, 0 # height vals not indices
        left = 0
        right = len(height) - 1
        
        total_water_trapped = 0
        
        while left <= right:
            
            if left_wall <= right_wall: # trap bw left wall and left pointer
                
                if left_wall > height[left]:
                    total_water_trapped += left_wall - height[left]
                    
                else:
                    left_wall = height[left]
                    
                    
                left += 1
                
            else: # trap between right walla nd right pointer
                
                if right_wall > height[right]:
                    total_water_trapped += right_wall - height[right]
                    
                else:
                    right_wall = height[right]
                    
                right -= 1
                
        return total_water_trapped
                    
                
                    