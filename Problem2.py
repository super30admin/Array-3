'''
Time Complexity: O(n) where n is length of citations list
Space Complexity: O(n)
Run on Leetcode: YES
'''
class Solution:
    def hIndex(self, citations: list[int]) -> int:
        n = len(citations)
        bucket = [0] * (n + 2)
        for citation in citations:
            if citation > n:
                bucket[-1] += 1
            else:
                bucket[citation] += 1
        count = bucket[-1]
        for index in range(len(bucket) - 2, -1, -1):
            count += bucket[index]
            if index <= count:
                return index