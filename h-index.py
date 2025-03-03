class Solution:
    # concept of bucket sort
    # TC : O(n)
    # SC : O(n)
    def hIndex(self, citations: List[int]) -> int:
        if citations is None:
            return 0
        n = len(citations)
        buckets = [0]*(n+1)
        for cit in citations:
            if cit >= n:
                buckets[n] += 1
            else:
                buckets[cit] += 1
        sumv = 0
        for i in range(n,-1,-1):
            sumv += buckets[i]
            if sumv >= i:
                return i
        return 0
        