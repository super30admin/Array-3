"""
TC/SC: O(N)/O(1)
"""
class Solution(object):
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        # a = [None for _ in nums]
        # n = len(nums)
        # k = k % n
        # for idx,val in enumerate(nums):
        #     a[(idx+k)%n] = nums[idx]
        # nums[:] = a
        # // solution 2
        
        k = k%len(nums)
        def reverseArray(start,end):
            while start < end:
                nums[start], nums[end] = nums[end], nums[start]
                start += 1
                end-=1
        reverseArray(0,len(nums)-1)
        reverseArray(0,k-1)
        reverseArray(k,len(nums)-1)
