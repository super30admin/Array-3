# Time Complexity = O(1)
# Space Complexity = O(n)

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        citations.sort()
        if len(citations) == 0:
            return 0
        for i, cit in enumerate(citations):
            diff = len(citations) - i
            if cit >= diff:
                return diff
        return 0
