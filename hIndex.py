# TimeComplexity:O(n)
# SpaceComlexity:O(1)
# Approach:
# You need to find break point where length -idx is samller than current citations

##################################
# Using Count/Bucket sort
##################################

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n=min(max(citations),5000)
        c=[0 for i in range(n+1)]
        for i in citations:
            c[i]+=1
        citations=[]
        for i in range(len(c)):
            if c[i]>=1:
                while(c[i]):    #be careful made mistake here
                    citations.append(i)
                    c[i]-=1
        l=len(citations)
        for i in range(len(citations)):
            if l-i<=citations[i]:

                return  l-i
        return 0


###################################
#With out count sort
###################################
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        citations.sort()
        l=len(citations)
        for i in range(len(citations)):
            if l-i<=citations[i]:

                return  l-i
        return 0

        
        

