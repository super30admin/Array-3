# -*- coding: utf-8 -*-
"""
TC: O(N) + NlogN to enumerate through the list of citations plus to sort the citations
SC: O(1) no extra space
"""

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        l=len(citations)
        citations=sorted(citations)
        for indx,ele in enumerate(citations):
            if ele>=(l-indx):
                return (l-indx)
        return 0