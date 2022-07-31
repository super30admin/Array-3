'''
Time Complexity: O(n) where n is length of nums list
Space Complexity: O(1)
Run on Leetcode: YES
'''
class Solution:
    def reverse(self, nums: list[int], i: int, j: int) -> None:
        while i < j:
            nums[i],nums[j] = nums[j],nums[i]
            i += 1
            j -= 1
            
    def rotate(self, nums: list[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        k = k % len(nums)
        self.reverse(nums, 0, len(nums) - 1)
        self.reverse(nums, 0, k - 1)
        self.reverse(nums, k, len(nums) - 1)