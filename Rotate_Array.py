# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#

class Solution:
    def swap(self, nums, start, end):
        start = start
        end = end
        while start < end:
            nums[start], nums[end] = nums[end], nums[start]
            start += 1
            end -= 1

    def rotate(self, nums: list[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        k = k % len(nums)
        self.swap(nums, 0, len(nums) - 1)
        self.swap(nums, 0, k - 1)
        self.swap(nums, k, len(nums) - 1)

# TC: O(n*k); SC: O(1)
# class Solution:
#     def rotate(self, nums: list[int], k: int) -> None:
#         """
#         Do not return anything, modify nums in-place instead.
#         """
#         while k != 0:
#             nums.insert(0, nums.pop())
#             k -= 1
