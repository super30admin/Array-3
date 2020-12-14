#Time Complexity : O(n)
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes


class Solution:
    def reverse(self, nums, left, right):
        while left < right:
            nums[left], nums[right] = nums[right], nums[left]
            left += 1
            right -= 1
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        if not nums:
            return
        n = len(nums)
        #case of k is bigger than length or given array
        k %= n

        #reverse the whole array
        self.reverse(nums, 0, n-1)
        #reverse first k elements
        self.reverse(nums, 0, k-1)
        #reverse last n-k elements
        self.reverse(nums, k, n-1)
