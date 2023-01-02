'''
Time Complexity -->O(nlogn) for sorting
Space Complexity --> O(1)
'''
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        
        citations.sort( reverse = True )
        
        for idx, citation in enumerate(citations):

            # find the first index where citation is smaller than or equal to array index            
            if idx >= citation:
                return idx
        
        return len(citations)