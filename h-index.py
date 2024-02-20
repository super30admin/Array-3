class Solution:
    def hIndex(self, citations: List[int]) -> int:
        
        citations = sorted(citations, reverse=True)
        ans = 0
        
        for i in range(len(citations)):
            if citations[i] > i:
                ans = ans + 1
                
        return ans
        
