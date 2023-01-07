import numpy as np
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        
        n = len(citations)

        # array to store number of papers for each citation. citations are represented by index.
        rs = np.zeros(n+1)
        running_sum = 0

        for i in citations:
            if i >= n:
                rs[n] += 1
            else:
                rs[i] += 1

        for i in range(n, -1, -1):
            running_sum += rs[i]
            if running_sum >= i:
                return i
