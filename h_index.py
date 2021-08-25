#Time Complexity: O(N)

#Space Complexity: O(N) 
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        counts = [0]*(n+1)
        for item in citations:
            if item>=n:
                counts[n]+=1
            else:
                counts[item]+=1
        papers = 0
        for i in range(n,-1,-1):
            papers+=counts[i]
            if papers>=i:
                return i