# -*- coding: utf-8 -*-
"""
Created on Tue Apr  7 00:48:34 2020

@author: aggar
"""

#Problem 1 Trap Rain Water
# TC - O(n) 
# SC - O(n)
# Yes, this solution worked. At every index, check maximum on left and maximum on right. Then take minimum from them and subtarct the at that particular index to get the water at that index.
class Solution:
    def trap(self, height: List[int]) -> int:
        if not height:
            return 0
        res = 0
        current = 0
        left = [0]*len(height) #first element of left array will be zero 
        right = [0]*len(height) #last element of right array will be zero
        for i in range(1,len(height)):
            left[i] = max(left[i-1],height[i-1])
        for i in range(len(height)-2,-1,-1):
            right[i] = max(right[i+1], height[i+1])
        for i in range(len(height)):
            current = min(left[i] , right[i]) - height[i]
            if current < 0:
                current = 0
            res += current  
        return res
