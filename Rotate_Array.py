"""
Time Complexity : O(n) for sorting
Space Complexity : O(1) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
Your code here along with comments explaining your approach:
we rotate the whole array, rotate first k elements, then rotate last n-k
"""


class Solution:
    def reverse(self, left, right, nums):
        while left < right:
            nums[left], nums[right] = nums[right], nums[left]
            left += 1
            right -= 1

    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        l = len(nums)
        k = k % l
        left = 0
        right = l-1
        self.reverse(left, right, nums)
        left = 0
        right = k-1
        self.reverse(left, right, nums)
        left = k
        right = l-1
        self.reverse(left, right, nums)
