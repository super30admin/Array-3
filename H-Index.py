# Time Complexity : O(N log N)
# Space Complexity : O(1)


class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)

        citations.sort()

        for i in range(len(citations)):
            if n-i <=  citations[i]:
                return n - i

        return 0