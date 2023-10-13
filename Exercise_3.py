# Problem2 H-Index (https://leetcode.com/problems/h-index/)

# Binary Search
# // Time Complexity : O(log n)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No
class Solution:
    def hIndex(self, citations):
        # if empty
        if not citations:
            return 0
        n = len(citations)
        # sort citations
        citations = sorted(citations)
        low = 0
        high = n - 1
        while low < high:
            mid = (low + high) // 2
            diff = n - mid
            if citations[mid] == diff:
                return diff
            elif citations[mid] < diff:
                l = mid + 1
            else:
                h = mid - 1
        return n - l


# Brute Force
# // Time Complexity : O(n)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No

# class Solution:
#     def hIndex(self, citations):
#         # if empty
#         if not citations:
#             return 0
#         n = len(citations)
#         # sort citations
#         citations = sorted(citations)
#         for i in range(n):
#             diff = n - i
#             if diff <= citations[i]:
#                 return diff
#         return 0


citations = [3, 0, 6, 1, 5]
sol = Solution()
print(sol.hIndex(citations))
