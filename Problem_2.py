# Runs on Leetcode
    # Runtime is O(n) and Space is O(n) where n is number of elements in citations list

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if not citations:
            return 0
        
        array = [0 for i in range(len(citations)+1) ]
        
        for i in range(len(citations)):
            if citations[i] >= len(citations):
                array[-1] += 1
            else:
                array[citations[i]] += 1
                
        s = 0
        for i in range(len(array)-1, -1, -1):
            s += array[i]
            if s >= i:
                return i
        return 0
