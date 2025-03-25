# Problem 3 : Rotate Array
# Time Complexity : O(n) where n is the length of the nums array
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach
from typing import List
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # check if the k is equal to 0
        if k == 0:
            # if it is then return
            return
        # check if the length of the nums is 1
        if len(nums) == 1:
            # if it is then return
            return
        # calculate the k module of length of nums for k greater than length of the nums
        k = k % len(nums)

        # define swap function to reverse the elements of nums array from startIndex to endIndex
        def swap (nums: List[int], startIndex: int, endIndex: int) -> None:
            # loop till the startIndex does not cross the endIndex
            while startIndex <= endIndex:
                # store the element at startIndex in temp
                temp = nums[startIndex]
                # store the element at endIndex in the startIndex position
                nums[startIndex] = nums[endIndex]
                # store the value of temp in at endIndex position
                nums[endIndex] = temp
                # increment the startIndex
                startIndex += 1
                # decrement the endIndex
                endIndex -= 1

        # call swap function with start index at 0 and end index as len(nums) ie. reverse entire array
        swap(nums, 0, len(nums)-1)
        # call swap function with start index at 0 and end index as k-1 ie. reverse first k elements of the array
        swap(nums, 0, k-1)
        # call swap function with start index at k and end index as len(nums) ie. rest of the array
        swap(nums, k, len(nums)-1)