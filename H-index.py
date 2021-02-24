class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if citations==None:
            return 0
        n=len(citations)
        buckets=[]
        for i in range(n+1):
            buckets.append(0)
        for i in range(n):
            if citations[i]>=n:
                buckets[n]+=1
            else:
                buckets[citations[i]]+=1
                
        summ=0
        for i in reversed(range(n+1)):
            summ+=buckets[i]
            if summ>=i:
                return i
            
        return summ
