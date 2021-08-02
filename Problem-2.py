"""
Approach: Bucket sorting
1. since there are n papers, the h-index can be n at max. If there are more than n citations for a paper, those can be added to a seperate bucket
2. You need to know how many papers have citations from 0 to n at each citation count. i.e. papers with citations 0, papers with citations 1..... papers with citations n
3. now just just apply the h index condition
    a) remember you need to have maximum possible h
TC: O(n)
SC: O(n)
"""
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        papers = [0] * (n+1) # indicies = citations ; values = papers
        
        for i in range(n): # find out the count of papers for each citation from 0 to n
            curr_citation = citations[i]
            if curr_citation < n:
                papers[curr_citation] += 1
            else:
                papers[-1] += 1 

        cummulative_sum = 0
        for i in range(n, -1, -1): # apply h index condition. i.e there have to be h papers with atleast h citations
            cummulative_sum += papers[i]
            if cummulative_sum >= i:
                return i
        return 0