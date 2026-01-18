"""
We use count sort method to find the papers that are present in the citations array, index represnets the number of citations per paper given, and hence we keep traversing the 
h index from back until the papers count >= h
Space is O(n) for extra count arrays stored and O(n) space for iterating the citations array"""


class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        n = len(citations)
        paperCount = [0] * (n + 1)
        
        for c in citations:
            paperCount[min(n,c)] += 1 #min condition to handle elements that are >= total citations

        h = n
        papers = paperCount[n]

        while papers < h:
            h -= 1
            papers += paperCount[h]
        return h


        