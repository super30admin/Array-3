from typing import List

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        k = k % len(nums)
        
        def twoPointer(nums, i, j):
            while i < j:
                nums[i], nums[j] = nums[j], nums[i]
                i += 1
                j -= 1

        if k > 0:
            twoPointer(nums, 0, len(nums)-1)
            twoPointer(nums, 0, k-1)
            twoPointer(nums, k, len(nums)-1)