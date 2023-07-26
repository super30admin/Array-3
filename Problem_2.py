"""
Problem : 2

Time Complexity : 
Bruteforce - O(nlogn)
Bucket Sort - O(n)

Space Complexity : 
Bruteforce - O(1)
Bucket Sort - O(n)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Bruteforce - 
Sorting the citations array, iterating from the start,
whenever a paper is encountered with more citations than there are papers left to check
it means thats the hindex

Bucket Sort - 
The maximum hindex would the total number of papers(n), so keeping count of the papers with same citations,
if a paper has more citations than the number of papers in the, considering their citations as n
starting from the end of this array, and adding the number of papers, when the sum of number of papers exceed the the current index
which represent the citations, then we have got the hindex
"""

# H-Index I

# Approach - 1
# Bruteforce - Sorting

class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """

        citations.sort()

        n=len(citations)
        for i in range(n):
            papers=n-i
            if papers<=citations[i]:
                return papers

        return 0
    
# Approach - 2
# Bucket Sort

class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        n=len(citations)
        bucket=[0 for _ in range(n+1)]

        for i in range(n):
            if citations[i]>=n:
                bucket[n]+=1
            else:
                bucket[citations[i]]+=1
        summ=0
        for i in range(n,-1,-1):
            summ+=bucket[i]
            if summ>=i:
                return i

        return 0