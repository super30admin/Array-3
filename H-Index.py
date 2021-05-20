class Solution:
    def hIndex(self, citations: List[int]) -> int:
                
        if not citations:
            return 0
        
        n = len(citations)
        buckets = [0] * (n+1)
        
        for i in citations:
            if i >= n:
                buckets[n] +=1
            else:
                buckets[i] +=1
        
        rsum = 0
        print(buckets)
        for i in range(n,-1,-1):
            rsum += buckets[i]
            if rsum >= i:
                return i
            
        return 0
            
        
        
