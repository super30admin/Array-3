"""
Time Complexity : O(n) where n is number of elements of the citations list
Space Complexity : O(n) where n is number of elements of the citations list and the space required is for the bucket

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Approach:
This problem can be solved with t.c. nlogn, as follows:
1. Sort the citations array
2. Start iterating over the citations array from 0 index
3. Check if the h-index can be (n-i) => if (n-i) >= citations[i] then (n-i) is the h-index.
   This is because (n-i) is maximum number having (n-i) citations for at least (n-i) papers

To improve on time, we can use bucket sort
1. Here we want to find the number h such that h number of papers should have at least h citations and h can be maximum number of papers published i.e. length of citations
2. So, the idea here is to count the number of papers having the same citations and checking if it satisfies the h-index criteria 
"""


class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if len(citations) == 0:
            return 0
        n = len(citations)
        bucket = [0 for _ in range(n+1)]

        for i in range(n):
            if citations[i] > n:
                bucket[n] += 1
            else:
                bucket[citations[i]] += 1

        currSum = 0

        for i in range(n, -1, -1):
            currSum += bucket[i]
            if currSum >= i:
                return i
        return 0
