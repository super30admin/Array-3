class Solution:
    
    """
        
        Name : Shahreen Shahjahan Psyche
        Time : O(NLogN) [bySorting method]
               O(N)     [byBucketSort method]
        Space : O(1)    [bySorting method]
                O(N)    [byBucketSort method]

        Paseed Test Cases : Yes
        
    """
    
    
    def bySorting(self, citation):
        citation.sort()
        i = 0
        while i < len(citation) and i < len(citation) - citation[i]:
            i += 1
        return len(citation) - i
        
    def byBucketSort(self, citations):
        
        n = len(citations)
        buckets = [0 for _ in range(n+1)]
        for i in citations:
            if i>=n:
                buckets[n] += 1
            else:
                buckets[i] += 1
        
        summed = 0
        for i in range(n, -1, -1):
            summed += buckets[i]
            if summed >= i:
                return i
        
    
    def hIndex(self, citations: List[int]) -> int:
        if not citations:
            return 0
        
        return self.byBucketSort(citations)
        return self.bySorting(citations)
