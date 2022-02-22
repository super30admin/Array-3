# Time Complexity : O(n)
# Space Complexity : O(n) - extra array for buckets
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

from typing import List


class Solution:
    def hIndex(self, citations: List[int]) -> int:
        # using the counting sort solution
        n = len(citations)
        arr = [0] * (n + 2)

        for i in range(n):
            # papers that have > n citations add one ucket to store
            if citations[i] > n:
                arr[n + 1] += 1
            else:
                arr[citations[i]] += 1

        accSum = arr[n + 1]

        # iterate in reversed order from the last second one
        for i in range(n, -1, -1):
            accSum += arr[i]

            if accSum >= i:
                return i

        return 0
