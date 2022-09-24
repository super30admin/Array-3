# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        
        n = len(citations)
        buckets = [0] *  (n + 1)
        
        for _, c in enumerate(citations):
            if c > n:
                buckets[n] += 1
            else:
                buckets[c] += 1
        s_sum = 0
        for i in range(n, -1, -1):
            s_sum += buckets[i]
            if s_sum >= i:
                return i
        return -1
    