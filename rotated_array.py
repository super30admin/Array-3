# -*- coding: utf-8 -*-
"""
TC:O(N) where N is the number of elements
SC:O(N) for extra array space
"""

class Solution(object):
    def rotate(self, nums, k):
        n=len(nums)
        rot=k%n    
        if(rot>0):              
            part1 = nums[:n-rot]
            x=n-rot+(len(nums[n-rot:n])-len(part1))
            nums[:x] = nums[n-rot:n]
            nums[x:]=part1