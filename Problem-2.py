# Time Complexity : O(n log n), n = length of citations array (due to sorting)
# Space Complexity : O(1), in-place sorting or negligible extra space
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# 1. Sort the citations array in ascending order.
# 2. Iterate from highest to lowest, checking how many papers have >= h citations.
# 3. The largest h where at least h papers have >= h citations is the H-index.
# 4. Return that value.

from typing import List

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        citations.sort()
        n = len(citations)
        for i in range(n):
            h = n - i  # number of papers from i to end
            if citations[i] >= h:
                return h
        return 0