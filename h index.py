# TC:O(n)
# SC:O(1)

class Solution:
    def hIndex(self, citations: List[int]) -> int: 

        #[3,0,6,1,5]
        #[0,1,3,5,6]
        #[5,4,3,2,1]

        citations.sort()
        N=len(citations)

        for i,val in enumerate(citations):
            if N-i<=val:
                return N-i
        return 0


