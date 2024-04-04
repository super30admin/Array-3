"""
Time Complexity : O(nlogn) where n is number of elements of the citations list
Space Complexity : O(1) as no auxillary data structure is used

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Approach:
This problem can be solved linearly, as follows:
1. Start iterating over the citations array from 0 index
2. Check if the h-index can be (n-i) => if (n-i) >= citations[i] then (n-i) is the h-index.
   This is because (n-i) is maximum number having (n-i) citations for at least (n-i) papers

This can be solved in logarithmic time using Binary Search.
"""


class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if len(citations) == 0:
            return 0
        n = len(citations)
        low = 0
        high = n - 1
        while low <= high:
            mid = (low + high) // 2
            diff = n-mid
            if citations[mid] == diff:
                return diff
            elif citations[mid] > diff:
                high = mid - 1
            else:
                low = mid + 1
        return n - low
