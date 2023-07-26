# Time Complexity : O(N) for each operation.
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

# Approach is to use bucket sort and use freq array
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        
        n=len(citations)
        bkts=[0]*(n+1)
        for i in range(0,n):
           
            if citations[i]>=n:
                bkts[n-1]+=1
            else:
                bkts[citations[i]]+=1
        su=0
        for i in range(n-1, 0, -1):
            su+=bkts[i]
            if su>=i:
                return i
        
        return 0