# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# In this approach, we firstly reverse all the elements of the array.
# We will have k % length of nums array if if k is greater than length of nums
# Then, reversing the first 0, k-1 elements followed by reversing the rest k, n−1 elements gives us the required result.

class Solution:
    def rotate(self, nums: list[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        #if k is greater than length of nums
        k = k % len(nums)
        self.reverseList(nums, 0, len(nums)-1)
        self.reverseList(nums, 0, k-1)
        self.reverseList(nums, k, len(nums)-1)
    
    def reverseList(self, nums, left, right):
        while left < right:
            nums[left], nums[right] = nums[right], nums[left]
            left += 1
            right -= 1