# Time complexity : O(nlogn)
# Space complexity : O(1)
# Leetcode : Solved and submitted

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        # sort the array
        citations.sort()
        n = len(citations)
        
        # traverse the array and find the diff till that index with the total length
        for i in range(n):
            diff = n - i
            # at any point we find the difference less than or equal to the value at that index return the diff
            if diff <= citations[i]:
                return diff
        # if nothing found, then return 0
        return 0
