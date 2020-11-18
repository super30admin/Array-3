"""
Leetcode: https://leetcode.com/problems/h-index/
Approach: Counting Sort (non-comparison sorting)

Time complexity : O(n). There are two steps. The counting part is O(n) since we traverse the citations array only once.
    The second part of finding the hh-index is also O(n) since we traverse the papers array at most once.
    Thus, the entire algorithm is O(n).
Space complexity : O(n). We use O(n) auxiliary space to store the counts.
"""


class Solution:
    def hIndex(self, citations: List[int]) -> int:
        numPapers = len(citations)
        papers = [0] * (numPapers + 1)  # papers[i] is the number of papers with i citations.

        # clipping the citations to number of papers
        for c in citations:
            papers[min(numPapers, c)] += 1

        # calculate the h index
        citation = numPapers
        freq = papers[numPapers]  # sum of papers with citations >= citation

        while citation > freq:
            citation -= 1
            freq += papers[citation]

        return citation