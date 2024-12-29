"""
calc freq map and count number of citations. if the number of citations greater than current index that's the H-index
TC: O(n)
SP:O(n)
"""
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        freq_map = [0]*(n+1)
        for c in citations:
            freq_map[min(c, n)]+=1
        sum = 0
        for i in range(n, -1, -1):
            sum+=freq_map[i]
            if sum>=i:
                return i


        