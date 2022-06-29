'''
Using Reverse Logic
Time: O(N)
Space: O(1)
Can also perform reversing the whole list after reversing part of lists
'''

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        if nums is None or len(nums) == 0:
            return None
        
        k = k % len(nums)
        
        self.reverse(nums,0,len(nums)-1)
        self.reverse(nums,0,k-1)
        self.reverse(nums,k,len(nums)-1)
        
    def reverse(self, nums, i, j):
        while i < j:
            nums[i],nums[j] = nums[j],nums[i]
            i += 1
            j -=1