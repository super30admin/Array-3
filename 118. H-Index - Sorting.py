class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if citations is None or len(citations) == 0:
            return 0

        n = len(citations)
        buckets = [0 for x in range(n+1)]
        for i in range(n):
            if citations[i] > n:
                buckets[n] += 1
            else:
                buckets[citations[i]] += 1

        sum = 0
        for i in range(len(buckets)- 1,-1, -1):
            sum += buckets[i]
            if sum >= i:
                return i
        return 0


# TC = O(N)
# Space complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : Syntax errors and index out of range