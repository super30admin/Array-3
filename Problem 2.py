# Time Complexity : O(n) where n is length of list
# Space Complexity :O(n)where n is length of list
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def hIndex(self, citations: List[int]) -> int:

        # Brute Force
        # citations = sorted(citations)
        # l = len(citations)
        # for idx, cit in enumerate(citations):
        #     if citations[idx] >= l-idx:
        #         return l-idx
        # return 0

        # Optimal
        l = len(citations)
        # created a  list with lenght 1 greater to store citations > lenght
        cits = [0] * (l + 1)

        # stored the citation c at index c of list cits. If c grater thn l then stored at last index
        for i in citations:
            cits[min(l, i)] += 1

        # Now index i of cits will have citations with value >= i
        summ = 0
        # Starting from back I have checked until papers(summ) <= citations(i) and returned citations
        for i in range(l, -1, -1):
            summ += cits[i]
            if summ >= i:
                return i
        return 0