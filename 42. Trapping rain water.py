class Solution:
    def trap(self, height: List[int]) -> int:
        maxId = -1  # For Storing the id of maximum elevation
        max = 0     # For Storing the value of max elevation
        n = len(height) # List size
        for i in range(n): # for finding the maximum elevation ( O(n) )
            if max < height[i]:
                max = height[i]
                maxId = i
        result = 0 # For storing the rain water
        lw = 0  # Acting as a left wall
        for i in range(maxId): # This loop is for calculating the water stored by the left part of max height
            if height[i]<lw: # Then only it'll hold the water
                result += (lw-height[i])*1
            else:
                lw = height[i]
        rw = 0 # Acting as right wall
        for i in range(n-1,maxId,-1): # This loop is for calculating the water stored by the right part of max height
            if height[i]<rw: # Then only it'll hold the water
                result += (rw-height[i])*1
            else:
                rw = height[i]
        return result    
