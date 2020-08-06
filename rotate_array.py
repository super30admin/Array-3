# Time Complexity : Add - O(2n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''
1. Reverse the array.
2. Reverse first k elements i.e 0 to k-1, and
3. Reverse last n-k elements.  
'''

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        
        if not nums or len(nums) < 2:
            return nums
        
        
        n = len(nums)
        k = k%n
        
        self.reverse(nums, 0, n-1)
        self.reverse(nums, 0, k-1)
        self.reverse(nums, k, n-1)
        
    
    def reverse(self, nums, start, end):
        
        while start < end:
            
            nums[start], nums[end] = nums[end], nums[start]
            start += 1
            end -= 1
            
        