class Solution:
    def hIndex(self, citations) :
        if citations == None:
            return 0
        n = len(citations)
        buckets = [0 for i in range(n + 1)]

        for i in range(n):
            if citations[i] >= n:
                buckets[n] += 1
            else:
                buckets[citations[i]] += 1
        papers = 0
        for i in range(n, -1, -1):
            papers += buckets[i]
            if papers >= i:
                return i
        return 0