class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if not citations or len(citations)==0:
            return 0
        papers=0
        n=len(citations)
        bucket=[0 for i in range(n+1)]
        
        for c in citations:
            if c>=n:
                bucket[n]+=1
            else:
                bucket[c]+=1
                
        for i in range(n,-1,-1):
            papers=papers+bucket[i]
            
            if papers>=i:
                return i
            
        return 0
                
       