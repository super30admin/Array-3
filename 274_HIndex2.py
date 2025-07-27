"""
TC: O(nlogn)+O(log n) ~ O(nlogn)
SC: O(1)
Sort and binary search
"""
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        citations.sort()
        n = len(citations)
        l = 0
        h = len(citations)-1
        while(l<=h):
            m = l+(h-l)//2
            if citations[m]==n-m:
                return citations[m]
            elif citations[m]>n-m:
                h=m-1
            else:
                l = m+1
        return n-l