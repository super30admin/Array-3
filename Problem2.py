# H Index
# Time Complexity: O(N log N)
# Space Complexity: O (1)

class Solution:
    def hIndex(self, citations: list[int]) -> int:
        citations.sort()
        n=len(citations)
        for i in range(len(citations)):
            if citations[i]>=n-i:
                return n-i
        return 0