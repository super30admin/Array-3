"""
Time Complexity : O(n) where n in the number of elements in array nums 
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        if len(nums) == 0:
            return
        n = len(nums)
        if k >= n:
            k = k % n
        # First we reverse all the numbers and then we reverse the first k numbers.
        # After that we have first k elements as per the final rotation so now we
        # reverse the remaining elements i.e n - k elements.
        self.reverse(nums, 0, n - 1)
        self.reverse(nums, 0, k - 1)
        self.reverse(nums, k , n - 1)
    def reverse(self, nums, l, r):
        while l < r:
            nums[l], nums[r] = nums[r], nums[l]
            l += 1
            r -= 1
        