"""
Time Complexity: O(n)
Space Complexity: O(1)
"""
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        if not nums or not k: return
        if len(nums) == 1: return
        if k > len(nums):
            k = k - len(nums)
        nums = self.reverse(nums, 0, len(nums)-1)
        nums = self.reverse(nums, 0, k-1)
        nums = self.reverse(nums, k, len(nums)-1)
        
    def reverse(self, nums, left, right):
        
        while left < right:
            nums[left], nums[right] = nums[right], nums[left]
            left += 1
            right -= 1
            
        return nums