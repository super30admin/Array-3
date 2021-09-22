"""
Time Complexity : O(n) where n is the number of citations 
Space Complexity : O(n) where n is the number of citations
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if len(citations) == 0:
            return 0
        n = len(citations)
        # Array to store the citations
        buckets = [0]*(n + 1)
        # We perform counting sort like we count number of papers having the citations         # mentioned in the citations array and change their freq in buckets array. We
        # then calculate the running sum from the end of the buckets array. The point 
        # at which the running sum equals the index from the buckets we return that 
        # index as my indices in the buckets indicate H-index
        for citation in citations:
            if citation >= n:
                buckets[n] += 1
                continue
            buckets[citation] += 1
        rSum = 0
        i = n
        while i >= 0:
            rSum += buckets[i]
            if rSum >= i:
                return i
            i -= 1
        return float('inf')