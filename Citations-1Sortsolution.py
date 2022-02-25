# Time Complexity nLOG(N)
# Space complexity o(1)
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        
        citations.sort()
        
        n = len(citations)
        for i in range(len(citations)):
            
            diff = n - i 
            
            if diff <= citations[i]:
                
                return diff
        
        return 0