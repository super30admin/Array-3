"""
We use the rotation controll by rotating the complete array first, then reverse till k and then reverse the rest
this ensures the requirements. 
This is done in place and hence complexity is O(1) for space and O(n) for time"""

class Solution(object):
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        if k > n:
            k = k% n
        
        def reverse(l ,r):
            while l < r:
                nums[l], nums[r] = nums[r], nums[l]
                l += 1
                r -= 1
        reverse(0, n-1) #revser whole
        reverse(0, k-1) #reverse till k
        reverse(k, n-1) #revser rest
        
        