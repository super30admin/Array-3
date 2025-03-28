#  https://leetcode.com/problems/h-index/


class Solution:
    def hIndex(self, citations: List[int]) -> int:
        citations.sort()        
        n = len(citations)
        for i in range(n):
            diff = n - i
            if diff <= citations[i]:
                return diff
        
        return 0

# TC : O(nlogn)
# SC: O(1)

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        buckets = [0] * (n+1)
        for i in range(n):
            if citations[i] >= len(buckets):
                buckets[n] += 1
            else:
                buckets[citations[i]] += 1
        if buckets[n] == n:
            return n
        for i in range(n-1,-1,-1):
            buckets[i] += buckets[i+1]
            if buckets[i] >= i:
                return i
        return 0

# TC : O(n)
# SC: O(n)