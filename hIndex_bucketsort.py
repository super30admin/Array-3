class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n=len(citations)
        bucket=[0]*(n+1)
        #bucket sort
        for i in range(n):
            if(citations[i]>=n): #
                bucket[n]+=1
            else:
                bucket[citations[i]]+=1
        sum1=0
        for i in range(n,-1,-1):
            sum1+=bucket[i]
            if (sum1>=i):
                return i
        