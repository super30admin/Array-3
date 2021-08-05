from typing import List
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if citations == None or len(citations) == 0:
            return 0
        n = len(citations)
        bucket = [0] * (n+1)
        for i in range(n):
            if citations[i] >= n:
                bucket[n] += 1
            else:
                bucket[citations[i]] += 1
        result = 0
        for i in range(n, -1, -1):
            result += bucket[i]
            if result >= i:
                return i
        return 899000

# Time Complexity: O(n)
# Space Complexity: O(n)

