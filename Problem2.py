#Time complexity: O(nlogn)
#Space complexity: O(1)
#Works on leetcode: yes
#Approach:First we order the values of f from the largest to the lowest value. 
#Then, we look for the last position in which f is greater than or equal to the position and this is the h-index. 

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        citations.sort(reverse = True)
        return sum(i < j for i, j in enumerate(citations))