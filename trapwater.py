# Time Complexity : O(N) for each operation.
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

# Approach is to use four pointer and move based on right wall and left wall.

class Solution:
    def trap(self, height: List[int]) -> int:
        lw=0
        rw=0
        l=0
        res=0
        r=len(height)-1
        while(l<=r):
            if (lw<=rw):
                if(lw>height[l]):
                    res+=lw-height[l]
                else:
                    lw=height[l]
                l+=1
            else:
                if(rw>height[r]):
                    res+=rw-height[r]
                else:
                    rw=height[r]
                r-=1
        
        return res