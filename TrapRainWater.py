#Time Complexity o(n)
#Space Complexity None


class Solution:
    def trap(self, height: List[int]) -> int:
        
        if height == None or len(height) == 0:
            return 0
#   Initializing left and right boundaries to zero      
        lw = 0
        rw = 0
        
#     Initializing left and right pointers    
        l = 0
        
        r = len(height) - 1
        
        result = 0 
#    We iterater till left pointer crosses right pointer     
        while(l <= r):
#    if Left boundary is less than or equal to right boundary we know that there is boundary down the line somewhere in the right which can trap water without overflow        
            if lw <= rw:
#   if height of left building is less than left boundary then we can trap the water over the building and the boundary.              
                if height[l] < lw:
                    result +=( lw - height[l]) *1
                else:
                    lw = height[l]
                l +=1
            else:
                if height[r] < rw:
                    result +=( rw - height[r]) *1
                else:
                    rw = height[r]
                r -=1
        return result
                    
        
        