from typing import List
# class Solution:
#     def hIndex(self, citations: List[int]) -> int:
#         citations.sort()
#         n = len(citations)
#         for i in range(n):
#             diff = n-i
#             if diff <=citations[i]:
#                 return diff
#         return 0

# class Solution:
#     def hIndex(self, citations: List[int]) -> int:
#         citations.sort()
#         n = len(citations)
#         l,h = 0, n-1
#         while l<=h:
#             mid = l+(h-l)//2
#             diff = n-mid
#             if diff == citations[mid]:
#                 return diff
#             elif diff > citations[mid]:
#                 l=mid+1
#             else:
#                 h=mid-1
#         return n-l
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        count = [0]*(n+1)
        for c in citations:
            if c>=n:
                count[n]+=1
            else:
                count[c]+=1
        totals = 0
        for i in range(n,-1,-1):
            totals+=count[i]
            if totals>= i:
                return i
            
        return 0
        