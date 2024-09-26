'''
Time Complexity: O(n)
Space Complexity: O(1)
Did this code successfully run on Leetcode : Yes
Explanation: reverse the list completely first then reverse the elements from 0 to k-1 and then reverse the elements
from k to n-1. If k>len(array) -> k = k%len(array)
'''
class Solution:
    def reverse(self, nums: List[int], start: int, end: int) -> list:
        while start < end:
            nums[start], nums[end] = nums[end], nums[start]
            start += 1
            end -= 1

    def rotate(self, nums: List[int], k: int) -> None:
        # Space O(1) and time O(1), reverse the list to shift characters
        if nums == None or k == None:
            return None

        n = len(nums)
        k = k % n
        self.reverse(nums, 0, n - 1)
        self.reverse(nums, 0, k - 1)
        self.reverse(nums, k, n - 1)

