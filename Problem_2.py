# class Solution:
#     def hIndex(self, citations):
#         n = len(citations)
#         freq = [0] * (n + 1)
#         for num in citations:
#             if num >= n:
#                 freq[n] += 1
#             else:
#                 freq[num] += 1
#         count = 0
#         for i in range(n, -1, -1):
#             count += freq[i]
#             if i <= count:
#                 return i
#         return 0
    
class Solution:
    def hIndex(self, citations):
        citations.sort()
        n = len(citations)
        for i in range(n):
            if citations[i] >= n - i:
                return n - i

        return 0
