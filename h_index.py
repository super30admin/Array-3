# Time complexity - O(n)
# Space Complexity: O(n) 
# Did this code successfully run on LeetCode?: Yes
# Problems faced while coding this:None
# Approach : Bucket sorting


class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if citations is None or len(citations) == 0:
            return 0
        
        n = len(citations)
        bucket = [0]*(n+1)
        for i in range(n):
            if citations[i] >= n:
                bucket[n] += 1
            else:
                bucket[citations[i]] += 1
            
        total = 0
        for i in range(n, -1, -1):
            total += bucket[i]
            if total >= i:
                return i