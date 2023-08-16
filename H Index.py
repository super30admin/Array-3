# Time Complexity : O(n)
# Space Complexity : O(n)

# The code ran on LeetCode

# Maintain a counter of number of citations. Traverse on this counter array in reverse order and find the index where the cummulative sum of citations >= current index

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        buckets = [0]*(n + 1)

        for c in citations:
            if c >= n:
                buckets[n] += 1
            else:
                buckets[c] += 1
        sum = 0
        for i in range(n, -1, -1):
            sum += buckets[i]
            if sum >= i:
                return i
        # return 0