'''
TC: O(n) - iterating through the list of all elements
SC: O(n) - creating a list with n spaces
'''
from typing import List

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        res = [0]*(n+1)
        for c in citations:
            if c >= n:
                res[-1]+=1
            else:
                res[c]+=1
        papers = 0
        for i in range(len(res)-1,-1,-1):
            papers += res[i]
            if papers >= i:
                return i
        return 0
s = Solution()
print(s.hIndex([3,0,6,1,5]))
print(s.hIndex([0, 2, 0, 1]))
print(s.hIndex([1,3,1]))
print(s.hIndex([4,4,0,0]))
print(s.hIndex([0,1]))
