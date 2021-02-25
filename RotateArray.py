# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# In this approach, we firstly reverse all the elements of the array.
# We will have k % length of nums array if k == length of nums then it will be the original array
# Then, reversing the first k elements followed by reversing the rest n−k elements gives us the required result.


class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        k = k % len(nums)
        self.reverseList(nums, 0, len(nums) - 1)
        self.reverseList(nums, 0, k - 1)
        self.reverseList(nums, k, len(nums) - 1)

    def reverseList(self, nums, left, right):
        while left < right:
            nums[left], nums[right] = nums[right], nums[left]
            left += 1
            right -= 1
