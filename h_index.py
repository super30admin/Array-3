# Time Complexity : O(N log N) where n is number of research papers
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        
        citations.sort()
        
        for i in range(len(citations)):
            if n-i <=  citations[i]:
                return n - i
                
        return 0