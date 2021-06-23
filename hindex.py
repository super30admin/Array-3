 TC: O(N) sc:= O(n)

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        result = [0]*(n + 1)
        for i in range(n):
            if citations[i] >= n:
                result[-1] += 1
            else:
                result[citations[i]] += 1

        sum = 0
        for j in range(len(result), -1, -1):
            sum += result[j]
            if sum >= j:
                return j

        return -1