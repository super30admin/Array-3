# Did this code successfully run on Leetcode : YES

# TC: O(N)
# SC: O(N)

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        # bucket sort technique
        n = len(citations)
        buckets = [0 for _ in range(n+1)]
        for i in range(n):
            if citations[i] >= n:
                buckets[n] += 1
            else:
                buckets[citations[i]] += 1
        rsum = 0
        for i in range(n, -1, -1):
            rsum += buckets[i]
            if rsum >= i:
                return i
        return 0