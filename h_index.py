class Solution:
    def hIndex(self, citations: List[int]) -> int:
        """
        Optimised - bucket sort
        TC:O(n)
        SC:O(n)
        """
        c=citations
        n=len(c)
        bucket=[0]*(n+1)
        for num in c:
            if num<n:
                bucket[num]+=1
            else:
                bucket[n]+=1
        summ=0
        for i in range(n,0,-1):
            summ+=bucket[i]
            if summ>=i:
                return i
        return 0
        
        
        
        
        """
        Not optimised 
        TC:O(nlogn + n)
        SC:O(1)
        """
        c=citations
        c.sort()
        for i in range(len(c)):
            if len(c)-i<=c[i]:
                return len(c)-i
        return 0