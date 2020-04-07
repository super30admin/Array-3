# Time Complexity : O(NlogN)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes

# Your code here along with comments explaining your approach
class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        if citations == None or len(citations) == 0:
            return 0
        citations.sort()
        n = len(citations)
        for i in range(n):
            citation = citations[i]
            count = n-i
            
            if citation >= count:
                return count
            
        return 0
        