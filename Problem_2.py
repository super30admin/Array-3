"""
Time Complexity : O(n) for traversing
Space Complexity : O(n) for that array 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Your code here along with comments explaining your approach:
We apply bucket sort for this question.
"""


class Solution:
    def hIndex(self, citations: List[int]) -> int:
        l = len(citations)
        temp = [0]*(l+1)
        for i in citations:
            if i > l:
                temp[l] += 1
            else:
                temp[i] += 1
        total = 0
        for i in range(l, -1, -1):
            total += temp[i]
            if total >= i:
                return i
