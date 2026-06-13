# time: O(nlogn)
# space O(1)
class Solution:
    def hIndex(self, citations: List[int]) -> int:

        citations.sort()
        n = len(citations)
        # once sorted, i tells you how many papers have fewer or equal citations
        for i in range(n):
            # i to end of array tells you how many papers have at least that many citations
            diff = n-i
            if diff <= citations[i]:
                return diff
        return 0

        # [0,1,3,5,6]

        # h papers that have each been cited at least h times
        # [11, 12, 25, 40, 100]
