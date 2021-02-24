"""
Time Complexity: O(n)
Space Complexity: O(n)
"""
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if not citations: return 0
        n = len(citations)
        
        paper_counts = [0] * (n+1)
        for citation in citations:
            if citation >= n:
                paper_counts[n] += 1
            else:
                paper_counts[citation] += 1
            
        currsum = 0
        for i in range(n, -1, -1):
            currsum += paper_counts[i]
            if currsum >= i:
                return i            
        
        return 0