from typing import List


class Solution:
    def hIndex(self, citations: List[int]) -> int:
        """
            https://leetcode.com/problems/h-index/
            Time Complexity - O(nlogn)
            'n' is the number of citations
            Space Complexity - O(1)
        """
        citations.sort()
        # no_of_papers : no_of_papers that have citations >= no_of_papers
        index, no_of_papers = len(citations) - 1, 0
        # looking for the first instance when the no of citations
        # is equal to or less than the no of papers
        while index >= 0 and citations[index] > no_of_papers:
            index -= 1
            no_of_papers += 1
        return no_of_papers

    def hIndex(self, citations: List[int]) -> int:
        """
            https://leetcode.com/problems/h-index/
            Time Complexity - O(n)
            'n' is the number of citations
            Space Complexity - O(n)
        """

        papers_with_citations = [0] * (len(citations) + 1)

        for citation in citations:
            # no of papers with citation_i
            papers_with_citations[min(citation, len(citations))] += 1

        cur_total_papers = 0
        for citation in reversed(range(0, len(papers_with_citations))):
            cur_total_papers += papers_with_citations[citation]
            if cur_total_papers >= citation:
                return citation


if __name__ == '__main__':
    print(Solution().hIndex([3, 0, 6, 1, 5]))
    print(Solution().hIndex([2, 0, 6, 1, 5]))
    print(Solution().hIndex([0, 4, 6, 1, 5]))
