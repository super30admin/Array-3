# Time Complexity : O(n)[n = length of citations list]
# Space Complexity : O(n)[n = length of citations list]
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Problem Approach - Bucket sort
# 1. The input is put into buckets on the basis of number of citations it has received
# 2. The bucket array is traversed in reverse order and as soon as the number of citation overlaps 
#     or exceed the index, the index is returned as output
# 3. Paper with citations more than n are put in bucket index n

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        citations_buckets = [0 for _ in range(n+1)]
        
        for curr in citations:
            citations_buckets[min(curr,n)]+=1
        s = 0
        for i in range(n, -1, -1):
            s+= citations_buckets[i]
            if s >= i:
                return i