class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if citations ==None or len(citations)==0:return 0
        n=len(citations)
        buckets=[0 for i in range(n+1)]
        for i in range(n):
            if citations[i]>n:
                buckets[n]+=1
            else:
                buckets[citations[i]]+=1
        sum1=0
        for i in range(n,-1,-1):
            sum1=sum1+buckets[i]
            if sum1>=i:
                return i
        return 0