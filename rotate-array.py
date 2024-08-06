from typing import List 
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        def reverse(nums, left, right):
            while left <= right:
                swap(nums, left, right)
                left+=1
                right-=1
            
        def swap(arr, left, right):
            temp = arr[left]
            arr[left] = arr[right]
            arr[right] = temp
        
        if nums is None or len(nums) == 0:
            return 
        n = len(nums)
        if k >= n:
            k = k%n
        
        reverse(nums, 0, n-1)
        reverse(nums, 0, k-1)
        reverse(nums, k, n-1)