# Sorting approach
class Solution:
    # Time Complexity - O(nlogn)
    # Space Complexity - O(1)
    def hIndex(self, citations) -> int:
        if citations is None or len(citations) == 0: return 0
        citations.sort()
        n = len(citations)

        for i in range(n):
            diff = n - i
            if citations[i] >= diff:
                return diff
        return 0


# O(n) solution using counting sort kinda solution
class Solution:
    # Time Complexity - O(n)
    # Space Complexity - O(n) for the new array that we'll create
    def hIndex(self, citations) -> int:
        if citations is None or len(citations) == 0: return 0
        n = len(citations)
        result = [0] * (n + 1)
        for i in range(n):
            if citations[i] > n:
                result[n] += 1
            else:
                result[citations[i]] += 1

        _sum = 0
        for i in range(n, -1, -1):
            _sum += result[i]
            if _sum >= i:
                return i

        return 0
