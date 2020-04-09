# -*- coding: utf-8 -*-
"""
Created on Tue Apr  7 00:58:00 2020
"""

#Problem 3 Rotate array
# TC - O(n) 
# SC - O(1)
# Yes, this solution worked. First reverse the whole array then reverse till k nad then reverse the rest n-k
class Solution:
    def reverse(self,nums,start,end) -> None:
        while start < end:
            temp = nums[start]
            nums[start] = nums[end]
            nums[end] = temp
            start += 1
            end -= 1
    def rotate(self, nums: List[int], k: int) -> None:
        k %= len(nums)
        self.reverse(nums,0,len(nums)-1)
        self.reverse(nums,0,k-1)
        self.reverse(nums,k,len(nums)-1)
        
        
       
        