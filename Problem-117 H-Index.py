# 274. H-Index
# https://leetcode.com/problems/h-index/

# Logic: Initialize a count array. Iterate over the input and 
# for every element update the count. If the element value is 
# more than n, update the element at nth position. Iterate the 
# count from the end and check if the count is greater than 
# equals index, return the index.

# Time Complexity: O(n)
# Space Complexity: O(n)

class Solution:
    def hIndex(self, citations) -> int:
        
        n = len(citations)
        
        count = [0 for i in range(n+1)]
        
        for i in citations:
            if i >= n:
                count[n] += 1
            else:
                count[i] += 1
        
        papers = 0
        for i in range(n, -1, -1):
            papers += count[i]
            if papers >= i:
                return i