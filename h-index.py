# // Time Complexity : O(n) if soted then O(nlogn)
# // Space Complexity : O(n) to store the buckets
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
# Method 1: buckets
# 1. create buckets of lenght n+1
# 2. iterate over citations and assign values for each bucket if value is less than n i.e.  size of array
# 3. from right calculate running sum over bucket and once we find sum >= index we return index
#
# Method 2:
# 1. Sort the array
# 2. iterate when we find n-i <= citations[i] : we return n-i
 
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        
        if citations == None or len(citations) == 0: return 0
        n = len(citations)
        bucket = [0]*(n+1)
        
        for i in citations:
            if i<n:
                bucket[i] += 1
            else:
                bucket[n] += 1
        s = 0
        for j in range(n,0,-1):
            s += bucket[j]
            if s >= j:
                return j
        return 0
            
            
        
#         citations.sort()
        
#         for i in range(len(citations)):
#             if n-i <= citations[i]:
#                 return n-i
#         return 0