"""
time: O(NlogN)
space: O(1)
"""

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        citations.sort()
        l, r = 0, len(citations)
        
        #find first idx where <= the num
        for i, n in enumerate(citations):
            if r-i <= n:
                return r-i
        
        return 0
        