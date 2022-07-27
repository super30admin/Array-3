# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
class Solution:
    def hIndex(self, citations) -> int:
        sort = [0] * (len(citations) + 1)
        for i in citations:
            if i >= len(citations):
                sort[len(citations)] += 1
            else:
                sort[i] += 1
        papers = 0
        for i in range(len(sort) - 1, -1, -1):
            papers += sort[i]
            if papers >= i:  # h-papers >= h which means n-h papers <=h
                return i
        return 0


print(Solution().hIndex([4, 2, 0, 3, 2, 5]))

# class Solution:
#     def hIndex(self, citations: List[int]) -> int:
#         citations.sort()
#         for i in range(len(citations)):
#             papers = len(citations) - i
#             if papers <= citations[i]:
#                 return papers
#         return 0
#
#
# print(Solution().hIndex([4, 2, 0, 3, 2, 5]))
