# H-Index

# Time Complexity : O(N)
# Space Complexity : O(N) as auxillary space is used
# Did this code successfully run on Leetcode : Yes, with Runtime 36 ms and Memory 14.5 MB
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
# Approach
"""
Using Bucket Sort we create a tradeoff between space and time So time complexity is
O(N). A buckets/array is created and that is initalized to 0 and than count is updated as iteration
is done. Starting from end to beginning when sum is greater than or equal to label
sum is returned.

"""
# Time Complexity - O(N)
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n=len(citations) # length of citations
        if(n==0 or citations==None): # Base Case
            return 0
        buckets=[0]*(n+1) # New Array
        for i in range(n):
            if(citations[i]>=n): # Creating buckets and count
                buckets[n]+=1
            else:
                buckets[citations[i]]+=1
        k=0 # for sum
        for i in range(n,-1,-1):  # Starting from end to beginning
            k+=buckets[i] 
            if(k>=i):
                hindex=i
                return hindex
        return 0


# Time Complexity-O(N log N) # Space-O(1)
class Solution:
        def hIndex(self, citations: List[int]) -> int:
            n=len(citations)
            if(n==0 or citations==None): # Base Case
                return 0
            citations=sorted(citations)
            for i in range(0,n):
                diff=n-i
                if(citations[i]>=diff):
                    return diff 
            return 0

# 