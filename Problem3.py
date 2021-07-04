# Time Complexity : O(N) (Where N is length of numbers)
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english:
# - Shifting by k is similer to reversing the number and than again reversing first k numbers and reversing remaining numbers.
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        ln = len(nums)
#       Converting k into range of ln.
        k = k % ln
#       Reversing whole number list
        self.reverse(nums, 0, ln - 1)
#       Reversing first k numbers
        self.reverse(nums, 0, k - 1)
#       Reversing remaining numbers
        self.reverse(nums, k, ln - 1)
            
#   Function to reverse the numbers in place
    def reverse(self, nums, start, end):
        while start < end :
            nums[start], nums[end] = nums[end], nums[start]
            start += 1
            end -= 1
