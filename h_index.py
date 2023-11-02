# Time Complexity: O(nlogn) where n is the length of the citations
#  Space Complexity: O(1)
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        citations.sort()
        r = len(citations)

        #find first idx where <= the num
        for i, n in enumerate(citations):
            if r-i <= n:
                return r-i

        return 0
