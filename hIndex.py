class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if citations is None or len(citations) == 0:
            return 0
        n = len(citations)
        buckets = [0] * (n + 1)
        for cite in citations:
            if cite >= n:
                buckets[n] += 1
            else:
                buckets[cite] += 1
        rsum = 0
        for i in range(n, -1, -1):
            rsum += buckets[i]
            if rsum >= i:
                return i

        return 0
