'''
Time Complexity: 0(n)
Space Complexity: 0(1)
Run on leetcode: Yes
'''
class Solution:
    
    def __init__(self):
        self.maxCapacity = 0
    
    def trap(self, height: List[int]) -> int:
        
        # get max wall
        maxWall = 0
        maxWallIdx = 0
        for i in range(0,len(height)):
            if maxWall < height[i]:
                maxWall = height[i]
                maxWallIdx = i
        
        # traverse from lhs till we reach the max height of the block
        lftBlk = 0
        lftPtr = 0
        
        while lftPtr <= maxWallIdx:
            
            if height[lftPtr] > height[lftBlk]:
                # lftBlk is grt then the lftPtr
                lftBlk = lftPtr
            else:
                # calculate the capcity and add it to the tempCapacity
                capacity = abs(height[lftBlk] - height[lftPtr])
                self.maxCapacity += capacity
            
            lftPtr += 1
        '''end of traversal from lhs'''
        
        # traverse from the rhs till we reach the case rtBlk == lftBlk
        rtPtr = len(height)-2
        rtBlk = len(height)-1
        
        while rtBlk != lftBlk and rtPtr >= maxWallIdx:
            
            if height[rtPtr] > height[rtBlk]:
                # rtBlk is grt then the rtPtr
                rtBlk = rtPtr
            else:
                # calculate the capcity and add it to the tempCapacity
                capacity = abs(height[rtBlk] - height[rtPtr])
                self.maxCapacity += capacity
            
            rtPtr -= 1
        
        '''end of traversal from lhs'''
        
        print("Max Capacity:\t",self.maxCapacity)
        return self.maxCapacity