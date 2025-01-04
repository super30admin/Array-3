# The hIndex method calculates the h-index for a researcher based on their citations.

# Use a bucket sort approach:
# - Count citations in buckets, with the last bucket aggregating citations >= number of papers.
# Traverse the buckets in reverse (from highest h-index):
# - Accumulate papers and return the h-index when the count meets or exceeds the index.

# TC: O(n) - Single traversal of citations and buckets.
# SC: O(n) - Space for the citation buckets.


from typing import List


class Solution:
    def hIndex(self, citations: List[int]) -> int:
        papers = len(citations)
        citation_buckets = [0] * (papers + 1)

        for citation in citations:
            citation_buckets[min(citation, papers)] += 1

        cumulative_papers = 0
        for h_index in range(papers, -1, -1):
            cumulative_papers += citation_buckets[h_index]
            if cumulative_papers >= h_index:
                return h_index   