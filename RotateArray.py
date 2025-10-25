# Time complexity: O(n) and space is O(1)
# The intuition is to do a couple of reversals. Firstly from 0 to n-k then from n-k to n-1 and finally reverse the entire array again.
# Also whenever the k is greater than the length of nums we can do a mod as the k is equal to len of nums then it would rotated an entire circle getting us the elements back
# at the same spot. Hence, we can do a mod.

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        if k > len(nums):
            k = k % n

        self.reverse(nums, 0, n - k - 1)
        self.reverse(nums, n - k, n - 1)
        self.reverse(nums, 0, n - 1)

    def reverse(self, nums, start, end):
        while start < end:
            nums[start], nums[end] = nums[end], nums[start]
            start += 1
            end -= 1