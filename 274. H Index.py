# Time and Space complexity : O(n), O(1)
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        citations.sort()
        for i in range(len(citations)):
            diff = len(citations) - i
            if (citations[i]>= diff):
                return diff
        return 0