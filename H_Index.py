class Solution:
    def hIndex(self, citations: List[int]) -> int:
        citations.sort(reverse = True)
        if not citations:
            return 0
        count = 0
        for i in range(len(citations)):
            if i+1<=citations[i]:
                count+=1
        
        return count 
time: O(nlogn)
space: O(1)
