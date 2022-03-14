# // Time Complexity : O(nlogn) where n is the length of the citations list.  
# // Space Complexity : O(1).
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Class Solution.
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        citations.sort()
        r = len(citations)
        for i, n in enumerate(citations):
            if r-i <= n:
                return r-i
        return 0
