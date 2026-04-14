# problem 2 

# https://leetcode.com/problems/h-index/

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        citations.sort()
        for idx,val in enumerate(citations):
            if n-idx <= val:
                return n-idx
        return 0