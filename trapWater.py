"""
Time Complexity : O(n) 
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this: none
"""

class Solution:
    def trap(self, height):
        n = len(height)
        amount = 0
        
        l = 0
        lw = 0
        r = n-1
        rw = 0
        
        while l <= r:
            if lw < rw:
                if lw <= height[l]:
                    lw = height[l]
                else:
                    amount += lw - height[l]
                    
                l += 1
            else:
                if rw <= height[r]:
                    rw = height[r]
                else:
                    amount += rw - height[r]
                
                r -= 1
                
        return amount
    
s = Solution()
print(s.trap([0,1,0,2,1,0,1,3,2,1,2,1]))