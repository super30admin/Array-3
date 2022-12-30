# Time Complexity : O(n), Where n is number of elements in height list 
# Space Complexity : O(1), 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nothing specific

from typing import List
class Solution:
    def trap(self, height: List[int]) -> int:
        n=len(height)
        lw=0
        rw=0
        l=0
        r=n-1
        res=0
        while(l<=r):
            if(lw<=rw):
                #Here lw plays an important role
                if(height[l]<=lw):
                    #update the res
                    res=res+(lw-height[l])
                else:
                    #update the lw, as we want as high as possible
                    lw=height[l]
                l+=1
            else:
                #Here rw plays an important role
                if(height[r]<=rw):
                    #update the res
                    res=res+(rw-height[r])
                else:
                    #update the rw, as we want as high as possible
                    rw=height[r]
                r-=1
        return res