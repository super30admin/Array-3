'''
TC: O(n)
SC: O(1)
'''
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        nlen = len(nums)
        if not nlen:
            return nums
        
        k = k % nlen
        
        def reverse(arr, start, end):
            while start < end:
                arr[start], arr[end] = arr[end], arr[start]
                start += 1
                end -= 1
        
        reverse(nums, 0, nlen - 1)
        reverse(nums, 0, k - 1)
        reverse(nums, k, nlen - 1)