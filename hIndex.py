# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        """
        by using bucket sorting
        """
        if not citations:
            return 0
        
        n = len(citations)
        buckets = [0 for i in range(n+1)]
        for i in range(len(citations)):
            if citations[i] >= n:
                buckets[n] += 1
            else:
                buckets[citations[i]] += 1
                
        totalSum = 0
        for i in range(n,-1,-1):
            totalSum += buckets[i]
            if totalSum >= i:
                return i
        return 0