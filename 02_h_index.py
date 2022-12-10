# https://leetcode.com/problems/h-index/
#TC: O(n + n) = O(n), O(n) for iterating over citation to get frequency, O(n + 1) for iterating over frequency bucket
#SC: O(n+1) = O(n), ie for iterating over frequency bucket

'''
Approach:

Creating a frequency bucket of length n+1 
Increasing the frequency in bucket => min between (citation & n) 
Then adding the frequencyies until we find the ith index <= the addition of frequencies

Eg: citations = [3,0,6,1,5]
FrequencyBucket = [1,1,0,1,0,1,1]
for i = 6, ans = 1
for i = 5, ans = 2
for i = 4, ans = 2
for i = 3, ans = 3 break here as ans >= index and return ans
'''
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        freqBucket = [0 for i in range(len(citations) + 1)]
        #sorting in buckets
        for citation in citations:
            freqBucket[min(citation, n)] += 1
            
        ans = 0
        
        for i in range(n, -1, -1):
            ans += freqBucket[i]
            
            if(ans >= i):
                return i
        
        return -1
        