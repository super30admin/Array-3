# // Time Complexity : O(n)
# // Space Complexity : o(1)
# // Did this code successfully run on Leetcode : Yes

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """

        if nums is None or len(nums) == 0:
            return nums
        n = len(nums)
        # if k is greater than len of nums

        k = k % len(nums)

        self.reverse(nums, 0, n - 1)
        self.reverse(nums, 0, k - 1)
        self.reverse(nums, k, n - 1)

    def reverse(self, nums, i, j):
        while i < j:
            nums[i], nums[j] = nums[j], nums[i]
            i += 1
            j -= 1


