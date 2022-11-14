#*******Brute force*************
#Time: O(nlogn)
#Space: O(1)

# class Solution:
#     def hIndex(self, citations: List[int]) -> int:
#         citations.sort()
#         for i in range(len(citations)):
#             if (len(citations) - i) <= citations[i]:
#                 return len(citations) - i
#
#         return 0

#******* Optimized *************
#Time: O(n)
#Space: O(n)
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        tmp = [0 for _ in range(n+1)]
        for i in range(len(citations)):
            if citations[i] > n:
                tmp[n] += 1
            else:
                tmp[citations[i]] += 1

        hIx = 0
        for i in range(n, -1, -1):
            hIx += tmp[i]
            if hIx >= tmp[i]:
                return i