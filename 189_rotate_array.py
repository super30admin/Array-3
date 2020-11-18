"""
Leetcode: https://leetcode.com/problems/rotate-array/
Approach: Using Reverse, In this approach, we firstly reverse all the elements of the array. Then, reversing the first k elements followed by reversing the rest n−k elements gives us the required result.

Time complexity: O(n). nn elements are reversed a total of three times.
Space complexity: O(1). No extra space is used.
"""


class Solution:
    def reverse(self, nums: list, start: int, end: int) -> None:
        while start < end:
            nums[start], nums[end] = nums[end], nums[start]
            start, end = start + 1, end - 1

    def rotate(self, nums: List[int], k: int) -> None:
        n = len(nums)
        k %= n

        self.reverse(nums, 0, n - 1)
        self.reverse(nums, 0, k - 1)
        self.reverse(nums, k, n - 1)