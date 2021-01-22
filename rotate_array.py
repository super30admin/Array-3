class Solution(object):
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        #O(3n)
        #O(1)
        n = len(nums)
        #bring k in range
        k =k% n
        #reverse complete list
        self.reverse(nums, 0, n - 1)
        #reverse 0-k elements (1st part)
        self.reverse(nums, 0, k - 1)
        #reverse k-n elements (2nd part)
        self.reverse(nums, k, n - 1)
        
    def reverse(self, nums, start, end):
        while start < end:
            nums[start], nums[end] = nums[end], nums[start]
            start, end = start + 1, end - 1
 
        