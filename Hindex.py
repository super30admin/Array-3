"""
274. H-Index
Time Complexity - O(n)
Space Complexity - O(len(citations))
We made a list which stores number of papers for that particular indexes.Then we calculated total papers starting from last index and compares if number of papers is greater than index value then return that value."""
"""
Do we have ____ papers >= citations?"""
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        result = [0]*(len(citations)+1)
        
        for value in citations:
            if value >= len(citations):
                result[len(citations)] += 1
            else:
                result[value] += 1
        
        papers = 0
        for i in range(len(citations),-1,-1):
            papers += result[i]
            
            if papers >= i:
                return i
        return -1
        
        