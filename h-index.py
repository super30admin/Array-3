from typing import List 
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        bucket = [0]*(n+1)

        for i in range(n):
            if citations[i] > n:
                bucket[n] += 1
            else:
                bucket[citations[i]]+=1
        
        sum = 0
        for i in range(n, -1, -1):
            sum+=bucket[i]
            if sum >= i:
                return i
        
        return 0

