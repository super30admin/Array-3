# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Your code here along with comments explaining your approach

class Solution(object):
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        d = [0]*len(nums)
        for i,v in enumerate(nums):
            d[(i+k)%len(nums)] = v
        for i in range(len(nums)):
            nums[i] = d[i]
            
            
        