from typing import List 
class Solution:
    def trap(self, height: List[int]) -> int:
        n = len(height)
        l = 0
        r = n - 1 
        lw = 0
        rw = 0
        result  = 0
        while l <= r:
            if lw <= rw:
                #rw acting as dam and process lw
                if(height[l] < lw):
                    #trap water
                    result+= lw - height[l]
                else:
                    lw = height[l]
                l+=1
            else:
                #right side
                if height[r] < rw:
                    result+= rw - height[r]
                else:
                    rw = height[r]
                r-=1
        
        return result 