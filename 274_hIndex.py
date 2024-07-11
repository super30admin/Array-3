class Solution:
    def hIndex(self, citations: List[int]) -> int:
        # n = len(citations)
        # citations.sort()
        # for i in range(len(citations)):
        #     if citations[i] >= n - i:
        #         return n - i
        # return 0
        # Time Complexity O(nlogn)
        # Space Complexity O(1)
        n = len(citations)
        buckets = [0] * (n + 1)
        for i in citations:
            if i >= n:
                buckets[n] += 1
            else:
                buckets[i] += 1

        result = 0
        for i in range(n, -1, -1):
            result += buckets[i]
            if result >= i:
                return i
        return 0

# Time Complexity O(n)
# Space Complexity O(n)