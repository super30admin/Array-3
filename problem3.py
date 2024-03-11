#Time Complexity : O(N)
#Space Complexity :O(N)
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this : No

from ast import List
from collections import deque


class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """

        k = k % len(nums)
        i = 0
        d = deque(nums)
        while i < k:
            temp = d.pop()
            d.appendleft(temp)
            i += 1
        nums[:] = d
        