# Time Complexity : O(n)
# Space Complexity : O(1)
class Solution:
    def hIndex(self, citations):
        n = len(citations)
        for i in range(len(citations)):
            diff = n - i
            if diff <= citations[i]:
                return diff
        return 0