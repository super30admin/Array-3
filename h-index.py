# Time Complexity : O(N) where N is length of citations array
# Space Complexity : O(N) as we are using a buckets array of size N+1
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:
# I am using a bucket sort approach to solve this problem.
# By using a bucket sort I can reduce the time complexity to O(N) rather than O(N log N) which would be the case if I sorted the citations array.
# I am creating a buckets array of size N+1 where N is the length of the citations array.
# I am iterating through the citations array and populating the buckets array.
# If the citation count is greater than N, I increment the last bucket (buckets[N]) as it represents all citation counts greater than N.
# Then I am iterating through the buckets array from the end to the start, maintaining a running sum of citations.
# When the running sum becomes greater than or equal to the current index, I return that index as the h-index.
# If no such index is found, I return -1.

from typing import List
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        buckets = [0] * (n+1)
        for i in citations:
            if i > n:
                buckets[n] +=1
            else:
                buckets[i] += 1
        sumy = 0
        for i in range(n,-1,-1):
            sumy += buckets[i]
            if sumy >= i:
                return i
        return -1



        
        