# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : YES

# Any problem you faced while coding this : NO

class Solution:
    def hIndex(self, citations: List[int]) -> int:

        buckets = [0] * (len(citations)+1)

        for c in citations:
            if c >= len(citations):
                buckets[len(citations)] += 1
            else:
                buckets[c] += 1
        
        tot_seen = 0
        for i in range(len(citations), -1, -1):
            tot_seen += buckets[i]
            if tot_seen >= i:
                return i
        