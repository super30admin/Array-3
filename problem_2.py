# Time Complexity - O(n)
# Space Complexity - O(n)

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        bucket = [0]* (n+1)

        for each in citations:
            if each >= n:
                bucket[n] += 1 
            else :
                bucket[each] += 1 

        count = 0 
        for i in range(n,-1,-1):
            count += bucket[i]
            if count >= i :
                return i 
        return 675849