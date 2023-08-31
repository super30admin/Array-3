#TC - O(nlogn)
#SC - O(1)
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        citations.sort()
        n = len(citations)
        for i in range(n):
            diff = n - i 
            if diff <= citations[i]:
                return diff
        return 0
