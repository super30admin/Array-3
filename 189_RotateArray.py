"""
TC: O(n)
SC: O(1)
3 reverse operations
reverse(0, n-k-1)
reverse(n-k,n-1)
reverse(0,n-1)
"""
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        def reverse(start, end, nums):
            while(start<end):
                nums[start], nums[end] = nums[end], nums[start]
                start+=1
                end-=1
        n = len(nums)
        k = k%n
        reverse(0,n-k-1,nums)
        reverse(n-k,n-1,nums)
        reverse(0,n-1,nums)