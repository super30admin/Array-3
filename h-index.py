class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        #bucket sort
        #O(N)
        #O(n)
        if not citations:
            return 0
        n=len(citations)
        buckets=[0]*(n+1)
        for i in range(n):
            if citations[i]>=n:
                buckets[n]+=1
            else:
                buckets[citations[i]]+=1
        localsum=0
        for i in range(n,-1,-1):
            localsum+=buckets[i]
            if localsum>=i:
                return i
        
            
            
       
            