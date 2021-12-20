#Time, space O(n)
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n=len(citations)
        h=[0]*(n+1)
        
#Counting the citations    
        for i in range(len(citations)):
            if citations[i]>n:
                h[n]+=1
            else:
                h[citations[i]]+=1
                
        print(h)
        
        papers=0
 #h-index       
        for j in range(n,-1,-1):
            papers+=h[j]
            if papers>=j:
                return j
            
        return -1
