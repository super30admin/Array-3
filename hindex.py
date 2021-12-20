"""
https://leetcode.com/problems/h-index/
"""


class Solution:
    def hIndex(self, citations: List[int]) -> int:
        """
        According to the definition of h-index on Wikipedia: A scientist has an index h if h of their n papers have at least h citations each, and the other n − h papers have no more than h citations each.If there are several possible values for h, the maximum one is taken as the h-index.
        h > h
        n-h<=h
        """
        """Solution 2: Bucket Sort
        we can use bucket sort hwen sorting only matters among few values
        """
        ###sorting o(n)
        ###sc O(n) for buckets
        if citations is None or len(citations) == 0:
            return 0
        n = len(citations)
        buckets = [0] * (n + 1)
        for i in range(n):
            if citations[i] >= n:
                buckets[n] += 1
            else:
                buckets[citations[i]] += 1

        result = 0
        for i in range(n, -1, -1):
            result += buckets[i]
            if result >= i:
                return i
        return 0

#         """Solution 1: nlogn"""
#         if citations is None or len(citations)==0:
#             return 0
#         n=len(citations)
#         print("length is", n)
#         citations.sort()
#         print("sorted citations", citations)
#         for i in range(n):
#             diff=n-i
#             """One thing to note is that hindex least can be 1 and it is just dependt on n and i and not dependent on actual values inside
#         ex: consider array - [3,0, 7,8,5,10]
#         the hindex can nonly lie between [1,2,3,4,5,6]
#         """
#             print(diff)
#             if diff<= citations[i]:
#                 print("inside if", diff)
#                 return diff
#         return 0


