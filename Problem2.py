# Since this is not sorted, we could use bucket sort - single pass
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        buckets = [0] * (n + 1)
        count = 0

        for i in range(n):
            if citations[i] >= n:
                buckets[n] += 1
            else:
                buckets[citations[i]] += 1
        for i in range(n, -1, -1):
            count += buckets[i]
            if count >= i:
                return i
        return 0

