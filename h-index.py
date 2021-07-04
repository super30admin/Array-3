"""
Time Complexity : O(n) 
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this: none
"""

class Solution:
    def hIndex(self, citations):
        n = len(citations)
        counts = [0 for i in range(n+1)]
        tot = 0
        
        for i in range(n):
            if citations[i] > n:
                counts[-1] += 1
            else:
                counts[citations[i]] += 1
        
        j = len(counts) - 1
        while j >= 0:
            tot += counts[j]
            if j <= tot:
                return j
            j -= 1

s = Solution()
print(s.hIndex([3,0,6,1,5]))