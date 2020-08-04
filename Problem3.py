"""
// Time Complexity : O(n), 
// Space Complexity : O(1), no extra
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
"""
class Solution:
    def rev(self, nums, l, h):
        
        while l < h:
            tmp = nums[l]
            nums[l] = nums[h]
            nums[h] = tmp
            l += 1
            h -= 1
            
        return nums
        
    
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        k = k%len(nums)
        
        nums = self.rev(nums,0,len(nums)-1) #reverse the entire list
        nums = self.rev(nums,0,k-1) #reverse first k-1 elements then the remaining
        self.rev(nums,k,len(nums)-1)