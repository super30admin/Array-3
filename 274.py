class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if len(citations) == 0:
            return 0
        n = len(citations)
        result = [0]*(n+1)
        for num in citations:
            if num >= n:
                result[n] += 1
            else:
                result[num] += 1
        sum1 = 0
        for i in range(n, -1, -1):
            sum1 = sum1 + result[i]
            if sum1 >= i:
                return i
        return 0 

    # TC : O(n)
    # SC : O(n)