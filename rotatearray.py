# Time Complexity : O(N) where N is the length of the array
# Space Complexity : O(1) as we doing in place rotation
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:
# I am checking length of array if k is greater than length then taking mod of k with length
# Then I am slicing the array into two parts from the end k elements and rest of the elements
# Finally I am concatenating both the parts to get the rotated array

from typing import List
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        if len(nums) < k :
            k = k % len(nums) 
        nums[:] = nums[-k:] + nums[:-k]
        