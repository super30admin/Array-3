'''
1. Keep a counts array of length equal to number of papers that tells us how many times a paper was cited index no. of times.
2. Any no. of times greater than the length of array would fall in last bucket. 
3. Traverse the counts array in reverse and take a cumulative sum until we reach a point where atleast (index) number of papers were cited 
index number of items. Return that index

TC: O(n)
SC: O(n)
'''

# 1st Approach
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)

        counts = [0]* (n+1)

        for cit in citations:
            if cit >= n :
                cit = n
            counts[cit] += 1
        
        cum__citations = 0
        for h in range(n,0,-1):
            cum__citations += counts[h]
            if cum__citations >= h:
                return h
        return 0
    