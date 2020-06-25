"""
    brute force: sort the array
    T = O(n log n * n)
"""
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        sum = 0
        buckets = [0 for i in range(n+1)]

        for i in range(n):
            buckets[min(n,citations[i])] += 1

        if buckets[n] >= n: return n

        for i in range(n,0,-1):
            sum += buckets[i]
            if sum >= i:return i
        return 0
            
