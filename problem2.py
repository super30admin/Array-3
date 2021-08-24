class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if citations==None:
            return 0
        n=len(citations)
        bucket=[0]*(n+1)
        for i in range(n):
            if citations[i]>=n:
                bucket[n]+=1
            else:
                bucket[citations[i]]+=1
        papers=0
        for i in range(len(bucket)-1,-1,-1):
            papers+=bucket[i]
            if papers>=i:
                return i
        return 0
       #Time O(n)
       #Space O(n)
