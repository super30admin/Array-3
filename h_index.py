'''
Space complexity : O(nlogn)

Time complexity :O(1)

Although there is an easier technique with binary search, for the time being I validated with only brute force solution
'''

class Solution:
    def hIndex(self, citations: List[int]) -> int:

        citations.sort()

        h_index = len(citations)

        for i in range(len(citations)):

            if(h_index<=citations[i]):
                return h_index
            else:
                h_index-=1


        return 0
