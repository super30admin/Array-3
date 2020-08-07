------------------------Trapping Rain water--------------------------------------------

# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# Here we will have left wall and right wall and pointer lon 0 and r on len(height)-1. we will first check if
left wall is less than right wall , we will process smallest side first and then we will check, if left wall 
is greater than height at l pointer, we will trap water with left wall and l pointer and add to res, In the same way we will trap
right side, we will iterate until we reach l and r pointers. 

class Solution:
    def trap(self, height: List[int]) -> int:
        if not height:
            return 0
        
        res = 0
        lw = 0
        rw = 0
        l = 0
        r = len(height)-1
        
        while l<=r:
            if lw<=rw:
                if lw>height[l]:
                    res += lw-height[l]
                else:
                    lw = height[l]
                l+=1
            else:
                if rw>height[r]:
                    res += rw-height[r]
                else:
                    rw = height[r]
                r-=1
        return res