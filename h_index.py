class Solution:
    def hIndex(self, citations: List[int]) -> int:

        n = len(citations)
        total = 0

        bucket = [0] * (n + 1)

        for c in citations:
            if c >= n:
                bucket[n] += 1
            else:
                bucket[c] += 1

        for i in range(n, -1, -1):
            total += bucket[i]
            if total >= i:
                return i
        return 0

    # time complexity is O(n)
    # space complexity is O(n)
