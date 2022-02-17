# // Time Complexity : O(n)
# // Space Complexity : o(n)
# // Did this code successfully run on Leetcode : Yes

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if citations is None or len(citations) == 0:
            return 0

        n = len(citations)
        result = [0] * (n+1)

        for citation in citations:
            if citation > n:
                result[-1] += 1
            else:
                result[citation] += 1

        sum = 0
        for i in range(len(result)-1,-1,-1):
            sum += result[i]
            if sum >= i:
                return i

        return 0

