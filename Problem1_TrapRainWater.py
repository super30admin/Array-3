'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

# 42. Trapping Rain Water


# https://leetcode.com/problems/trapping-rain-water/

#-----------------
# Time Complexity: 
#-----------------
# O(N): Maximum N elements traversed
#------------------
# Space Complexity: 
#------------------
# O(1) - Need 4 temporary variables. Constant space

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes

class Solution:
    def trap(self, height: List[int]) -> int:
        if len(height) < 2:
            return 0
        result = 0
        n = len(height)
        l = 0 #left ptr
        r = n-1  #right ptr
        
        lw = 0 #left wall
        rw = 0 #right wall
        
        while l <= r:
            if lw <= rw:
                #process smaller side first
                if height[l] < lw:
                    result += lw - height[l]
                else:
                    lw = height[l]
                
                l += 1
                
            else:
                if height[r] < rw:
                    result += rw - height[r]
                else:
                    rw = height[r]
                
                r -= 1
            
        return result