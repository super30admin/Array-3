# Time Complexity : O(N), where N is the length of the citations list
# Space Complexity : O(N)
from typing import List

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        count = [0] * (n + 1)

        # Count the number of papers with each citation count
        for citation in citations:
            count[min(citation, n)] += 1

        # Find the largest h-index
        h = n
        papers = count[n]
        while h > papers:
            h -= 1
            papers += count[h]

        return h