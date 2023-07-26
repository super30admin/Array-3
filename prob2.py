# Time Complexity : O(n)
# Space Complexity :O(n)
# Passed on Leetcode: yes

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        arr = [0] * (n + 1)

        for citation in citations:
            if citation >= n:
                arr[n] += 1
            else:
                arr[citation] += 1

        s = 0
        for i in range(n, -1, -1):
            s += arr[i]
            if s >= i:
                return i

        return 0