# Time Complexity :O(n logn)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode :yes
# Any problem you faced while coding this : N/A
# Your code here along with comments explaining your approach: I have followed the optimal approach discussed in the class.
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if(citations is None or len(citations) == 0):
            return 0
        citations.sort()
        i = 0
        h = []
        index = len(citations)
        while i <= len(citations)-1:
            if citations[i] >= index:
                return index
            i += 1
            index -= 1
        return 0 

# Approach 2:
# Time Complexity: O(n)
# Using bucket sort.
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        if(citations is None or n == 0):
            return 0
        buckets = [0] * (n+1)
        for i in citations:
            if i >= n:
                buckets[n] += 1
            else:
                buckets[i] += 1
        sum = 0
        
        for i in range(n,0,-1):
            sum += buckets[i]
            if sum >= i:
                return i
        return 0            