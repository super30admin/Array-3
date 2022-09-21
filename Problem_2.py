"""
Problem2 H-Index (https://leetcode.com/problems/h-index/)
https://leetcode.com/problems/h-index-ii/
"""

# H-index - ii
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        """
        TC : O(N) len of citations
        SC: O(1)
        """
        if citations == None or len(citations) == 0: return 0
        n = len(citations)
        for i in range(n):
            diff = n - i
            if diff <= citations[i]:
                return diff
            
        return 0

# H-index - ii
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        """
        Optimized using Binary search
        TC : O(logn)
        SC: O(1)
        """
        if citations == None or len(citations) == 0: return 0
        n = len(citations)
        l = 0
        h = n-1
        while (l <= h):
            m = (l+h)//2
            d = n - m
            if citations[m] == d:
                return d
            elif citations[m] < d:
                l = m + 1
            else:
                h = m - 1
    
        return n - l

# H-Index

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        """
        TC :O(nlogn)
        SC : O(N)
        """
        if citations == None or len(citations) == 0: return 0
        n = len(citations)
        citations.sort()
        for i in range(n):
            diff = n - i
            if diff <= citations[i]:
                return diff
            
        return 0
        
# Approach - 2
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        """
        Bucket sort
        TC: O(N)
        SC:O(N)
        """
        if citations == None or len(citations) == 0: return 0
        n = len(citations)
        buck = [0 for _ in range(n + 1)]
        _sum = 0
        
        for i in range(n):
            if citations[i] >= n:
                buck[n] += 1
            else:
                buck[citations[i]] += 1
         
        for i in range(n ,-1, -1):
            _sum += buck[i]
            
            if _sum >= i: return i
            
        return 0
        
        