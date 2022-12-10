"""
https://leetcode.com/problems/h-index/description/
TC: O(nlogn)
SC : O(1)
Submiited to Leetcode: YES
"""


class Solution:
    def hIndex(self, citations: List[int]) -> int:

        citations.sort(reverse = True)

        for index, citation in enumerate(citations):
            if index >= citation:
                return index

        return len(citations)