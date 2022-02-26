"""
Given n non-negative integers representing an elevation map where 
the width of each bar is 1, compute how much water it can trap after raining.

"""

# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on leetcode : Yes
# Any problem you faced while coding this : No

from typing import List

class Solution:
    def trap(self, height: List[int]) -> int:

        if height == None or len(height) == 0:
            return 0
     
        lw = 0
        rw = 0 
        l = 0
        r = len(height) - 1

        result = 0 
    
        while(l <= r):
            
            if lw <= rw:  
                
                if height[l] < lw:
                    result += (lw - height[l]) * 1
                else:
                    lw = height[l]
                l +=1
            else:
                if height[r] < rw:
                    result += (rw - height[r]) * 1
                else:
                    rw = height[r]
                    
                r -=1
                
        return result
