#Time Complexity -- O(nlogn) - Sorting the array
#Space Compleexity -- O(1)
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if not citations:
            return 0
        
        
        citations.sort()
        n = len(citations)
        
        for i in range(len(citations)):
            diff = n-i
            if diff <= citations[i]:
                return diff
            
        return 0
