class Solution:
    def hIndex(self, citations: List[int]) -> int:
        citations.sort(key=lambda x: -x)
        hidx=0
        for papers, cites in enumerate(citations):
            if papers+1<=cites:
                hidx+=1
            else:
                break
        
        return hidx

