#Time Complexity: O(nlogn)
#Space Complexity: O(1)
#Run on Leetcode: Yes
#Any Issues: No

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        citations.sort();
        
        i = -1
        count = 0
        while abs(i)<=len(citations):
            if citations[i]>=-i:
                count = count+1
                   
            i = i-1
        return count