class Solution:
    def hIndex(self, citations: List[int]) -> int:
        h_index = [0] * (len(citations)+1)

        papers = 0
        h = len(citations)
        for i in citations:
            h_index[min(i,len(citations))] +=1


        for i in range(h,-1,-1):
            papers = papers + h_index[i]
            if papers >= i:
                return i