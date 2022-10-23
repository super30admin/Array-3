#Time: O(n)
#Space: O(n)
#Program ran on leetcode successfully

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        temp = [0 for _ in range(n+1)]
        for i in range(len(citations)):
            if citations[i] > n:
                temp[n] += 1
            else:
                temp[citations[i]] += 1
            
        hIx = 0
        for i in range(n, -1, -1):
            hIx += temp[i]
            if hIx >= temp[i]:
                return i