class Solution:
    def hIndex(self, citations: List[int]) -> int:
        """
        T: O(N)
        S: O(N)
        """
        if len(citations) == 0:
            return 0
        
        n = len(citations)
        sort_array = [0]*(n+1)
        
        for c in citations:
            if c>=n:
                sort_array[n]+=1
            else:
                sort_array[c]+=1
        
        papers = 0
        for x in range(n, 0, -1):
            papers += sort_array[x]
            if papers >= x:
                return x
        return 0
        