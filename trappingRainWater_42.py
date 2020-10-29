# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#Approach and Intuition:
#We need to: Find out all pockets where the water can be trapped. So we need to maintain a left width and right width in order to keep moving forward, initially both are 0. Maintain a running volume:total. In case LW<RW: calculate(subtracting to move left to right or right to left) left side else calculate right side. If LW is smaller than the height(L), assign LW as height(L):  increase the width! Otherwise, if my LW is >= height(L), calculate and add to total: LW-height(L), meaning we have something to hold water in and hence we add the volume to our total and move to the next building(L++). Similarly from RHS.

class Solution:
    def trap(self, height: List[int]) -> int:
        if height ==None or len(height)==0:
            return 0
        
        total,LW,RW, L, R = 0,0,0,0, len(height)-1
        
        while L<=R:
            if LW<RW:
                if LW<height[L]:
                    LW = height[L]
                else:
                    total += LW-height[L]
                    
                L+=1
                
            else:
                if RW<height[R]:
                    RW = height[R]
                else:
                    total += RW - height[R]
                    
                R-=1
                
        return total
        

