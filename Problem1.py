# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# taking four pointers l,r is the pointers and lw,rw is heght of the walls

# processing the lower wall first such that there exists an wall with greater height
# so that water will not spill

# finding the buildings with lesser height than walls to fill water in the spaces

# if there is a building with greater height then move the corresponding wall to that height
class Solution:
    def trap(self, height: List[int]) -> int:
        
        if height == None or len(height) < 2:
            return 0
        
        n = len(height)
        result = 0
        
        l,r,lw,rw = 0,n-1,0,0
        
        while l <= r:
            
            if lw <= rw:
                
                if height[l] < lw:
                    result += (lw-height[l])
                else:
                    lw = height[l]
                l += 1
            else:
                if height[r] < rw:
                    result += (rw-height[r])
                else:
                    rw = height[r]
                r -= 1
        return result
                
        