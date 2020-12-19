class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n=len(citations)
        citations.sort()
        for i in range(n):
            diff=n-i
            if(diff<=citations[i]):
                return diff
        return 0