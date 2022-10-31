#Use Bucket SOrt
#Time -> O(n)
#SPace-> (n)

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n=len(citations)
        buckets=[0]*(n+1)
        
        #If the citations are greater then put it inthe last block of array
        for i in range(n):
            if citations[i]>=n:
                buckets[n]+=1
            else:
                buckets[citations[i]]+=1
                
        my_sum=0
        
        #Traverse from the last
        for i in range(n,-1,-1):
            my_sum+=buckets[i]
            if my_sum>=i:
                return i
            
        return 0