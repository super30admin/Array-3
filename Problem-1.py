#Time Complexity :o(n) 
#Space Complexity :o(n)
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this :no

class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        if(citations==None):
            return 0
        n=len(citations)
        
        bucket=[0]*(n+1)
        
        for i in range(n):
            if(citations[i]>=n):
                bucket[n]+=1
            else:
                bucket[citations[i]]+=1
        sum=0
        for i in range(n,-1,-1):
            sum+=bucket[i]
            if(sum>=i):
                return i
                
        return 0
        