# Time Complexity : O(n)
# Space Complexity : O(1)
# Code ran on LeetCode
# Swap the entire array. Swap the first k elemensts and swap the next n - k elements 
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        k = k%len(nums)
        def swap(arr, l, r):
            while l < r:
                arr[l], arr[r] = arr[r], arr[l]
                l += 1
                r -= 1
        swap(nums, 0, len(nums) - 1)
        swap(nums, 0, k-1)
        swap(nums, k, len(nums) - 1)
        return nums