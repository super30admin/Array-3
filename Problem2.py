# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
# Problem Name: H-Index II

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        low, high = 0, n - 1

        while low <= high:
            mid = low + (high - low)//2
            diff = n - mid
            if citations[mid] == diff:
                return diff
            elif citations[mid] > diff:
                high = mid -1
            else:
                low = mid + 1
        return n - low