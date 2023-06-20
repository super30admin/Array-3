# Time Complexity: O(nlogn)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
"""
The answer is found by sorting the array and then finding the index where the citation is less than or equal to the index.
"""

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if citations is None or len(citations) == 0: return None

        citations.sort(reverse=True)

        for index, citation in enumerate(citations):
            if citation <= index:
                return index
        
        return(len(citations))