"""
Given an array, rotate the array to the right by k steps, where k is non-negative.
"""

# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on leetcode : Yes
# Any problem you faced while coding this : No

from typing import List

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # null case
        if not nums or len(nums) < 2:
            return
            
        if k == 0:
            return
    
        if k >= len(nums):
            k = k % len(nums)

        self.reverse(nums, 0, len(nums)-1)

        self.reverse(nums, 0, k-1)

        self.reverse(nums, k, len(nums)-1)

    def reverse(self,nums, l, r):
        
        while(l <= r):
            temp = nums[r]
            nums[r] = nums[l]
            nums[l] = temp
            l +=1
            r -=1