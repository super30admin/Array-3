class Solution:
    #Solution 1
    def hIndex(self, citations: List[int]) -> int:
        #Approach: Bucket sort
        #Time Complexity: O(n)
        #Space Complexity: O(n)
        #where, n is the length of citations list
        
        n = len(citations)
        
        numCitations = [0 for _ in range(n+1)]
        for citation in citations:
            if citation >= n:
                numCitations[n] += 1
            else:
                numCitations[citation] += 1
                
        totalCitations = 0
        for i in range(n, -1, -1):
            totalCitations += numCitations[i]
            
            if totalCitations >= i:
                return i
            
        return 0
    
    #Solution 2
    """
    def hIndex(self, citations: List[int]) -> int:
        #Approach: Sort, then Linear Search     // can also do binary search
        #Time Complexity: O(n log n)
        #Space Complexity: O(1)
        #where, n is the length of citations list
        
        n = len(citations)
        
        citations.sort()
        for i in range(n):
            if citations[i] >= n - i:
                return n - i 
        return 0
    """