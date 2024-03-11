#Time Complexity : O(n log n)
#Space Complexity :O(1)
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this : No
from ast import List


class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)

        citations.sort()

        for i, citation in enumerate(citations):
            if citation >= n - i:
                return n - i

        return 0
       