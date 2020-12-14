# Time Complexity: O(n)
# Space Complexity: O(n)
class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        n = len(citations)
        buckets = [0 for _ in range(n+1)]
        
        for c in citations:
            if c >= n:
                buckets[n] += 1
            else:
                buckets[c] += 1
        
        count = 0
        for i in reversed(range(n+1)):
            count += buckets[i]
            if count >= i:
                return i
        
        