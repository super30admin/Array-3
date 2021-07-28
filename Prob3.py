class Solution(object):
    def rotate(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        n = len(nums)
        if k == 0 or n<2:
            return nums
        if k>=n:
            k = k%n
        def reverse(nums,i,j):
            while i<j:
                swap(nums,i,j)
                i+=1
                j-=1
            
        def swap(nums,i,j):
            temp = nums[i]
            nums[i] = nums[j]
            nums[j] = temp
        
        reverse(nums,0,n-1)

        reverse(nums,0,k-1)

        reverse(nums,k,n-1)
