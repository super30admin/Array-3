------------------------HIndex--------------------------------------------

# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# 
# Here we use bucket sort, if we have citations more than the bucket length we will just add at the last element of the array.
# Once we sort and find the number of papers at each citation, we will then add the number of papers from the last
and when ever our total papers cross the citation count, we will return that citation as hindex. 


class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if not citations:
            return 0
        
        n = len(citations)
        bucketSort = [0 for i in range(len(citations)+1)]
        for i in citations:
            bucketSort[min(i,n)] +=1
        
        j = 0
        for k in range(n, -1, -1):
            j += bucketSort[k]
            if j>=k:
                return k
        return -1