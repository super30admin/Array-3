"""
Time Complexity : O(n) 
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this: none
"""

class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        """
            [1,2,3,4,5,6,7] - initial array
            [7,6,5,4,3,2,1] - reverse the full array
            [5,6,7,4,3,2,1] - reverse first k elements again to get the desired order
            [5,6,7,1,2,3,4] - reverse the rest of the array to get the final output
        """
        n = len(nums)
        if k > n:
            k = k % n
        
        self.rev(nums, 0, n-1)
        self.rev(nums, 0, k-1)
        self.rev(nums, k, n-1)
        
    def rev(self, nums, i, j):
        while i <= j:
            nums[i], nums[j] = nums[j], nums[i]
            i += 1
            j -= 1
        