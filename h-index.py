##Solution :- Time Compexity: - nlogn + n
# space complexity:- O(1)
class Solution:
    def hIndex(self, citations: List[int]) -> int:

        citations.sort()
        n = len(citations)
        h = n
        for i in range(len(citations)):
            if citations[i] >= h:
                return h
            h -= 1
        return 0

