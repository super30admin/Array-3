# -*- coding: utf-8 -*-
"""
TC: O(N) where N is the number of occurences of height
SC: O(N) for storing the heights in an array
"""

class Solution(object):
    def trap(self, height):
	
		# edge cases
        if not height or len(height) < 3:
            return 0
        
        n = len(height)
        
        l_max = [None] * n
        l_max[0] = height[0] # setting the last element
        
        r_max = [None] * n
        r_max[n-1] = height[n-1] # setting the first element

        i = 1 # i starts from height[1] instead of height[0]
        j = n-2 # j starts from height[n-2] instead of height[n-1]
        
        while i < n and j >= 0: # filling leftMax and rightMax arrays in one single loop
            l_max[i] = max(l_max[i-1],height[i])
            r_max[j] = max(r_max[j+1], height[j])
            i+=1
            j-=1
        
		# getting the final ans ie.  totalsum
        total_sum = 0
        for i in range(1, n-1):
            total_sum += min(r_max[i], l_max[i]) - height[i]
        
        return total_sum