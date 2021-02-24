# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english
# I go from left to right collecting all the trapped water and then right to left collecting all the trapped water. I ignore the pair from right to left which was
# used from left to right. I return all the added water.

class Solution:
    def trap(self, height: List[int]) -> int:
        left = 0
        right = 1
        water = 0
        current_blocks = 0
        s = set()
        while right < len(height):
            if right - left < 1:
                right += 1
            if height[right] >= height[left]:
                if height[right] == height[left]:
                    s.add(left)
                water += (height[left]*(right-(left+1))) - current_blocks
                current_blocks = 0
                left = right
                right = left+1
            else:
                current_blocks += height[right]
                right+=1    
                
        current_blocks = 0
        right = len(height) - 1 # 2
        left = right - 1 # 1
        while left >= 0: 
            if right - left < 1: 
                left-=1
                
            if height[left] >= height[right]:# 0, 2
                if left not in s:
                    water += (height[right]*(right-(left+1))) - current_blocks
                    current_blocks = 0
                right = left
                left = right-1
            else:
                current_blocks += height[left]
                left-=1
        
        return water
            
            
            
        
