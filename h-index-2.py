###########Binary Solution ################
#Time -> (log N)
#Space -> O(1)

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n=len(citations)
        l,h=0,n-1
        
        while l<=h:
            mid=(l+h)//2
            diff=n-mid
            if citations[mid]==diff:
                return diff
            elif citations[mid]<diff:
                l=mid+1
            else:
                h=mid-1
        
        return n-l


######Linear Solution########

#Time -> O(n)
#Space -> O(1)


class Solution:
    def hIndex(self, citations: List[int]) -> int:
        #iterate though the iterations
        n=len(citations)
        
        #Compare the difference and if the diff is equal or less then return that difference
        for i in range(n):
            diff=n-i
            if diff<=citations[i]:
                return diff
            
        return 0
    
    
        