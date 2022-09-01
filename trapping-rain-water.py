"""
Runtime Complexity:
O(n) - we use four pointers and traverse over the given list. Here 'n' is the length of the height.
Space Complexity:
O(1) - no extra space was required to compute the solution.
Yes, the code worked on leetcode.
Issues while coding -No
"""

class Solution:
    def trap(self, height: List[int]) -> int:
        n = len(height)
        if n == 0:
            return 0
        l,r = 0,n-1
        lw,rw = 0,0
        result = 0
        while l<=r:
            if lw<=rw:
                if height[l]<lw:
                    result+=lw-height[l]
                else:
                    lw = height[l]
                l+=1
            else:
                if height[r]<rw:
                    result+=rw-height[r]
                else:
                    rw = height[r]
                r-=1
        return result
        