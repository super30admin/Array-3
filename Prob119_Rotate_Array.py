#Time Complexity :o(n)
# Space Complexity :o(1)
# Did this code successfully run on Leetcode : yes
#Any problem you faced while coding this : no

class Solution(object):
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        k%= len(nums)
        nums[:] = nums[-k:] + nums[:-k]