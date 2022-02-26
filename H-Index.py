"""
Given an array of integers citations where citations[i] 
is the number of citations a researcher received for their ith paper, 
return compute the researcher's h-index.

According to the definition of h-index on Wikipedia: 
A scientist has an index h if h of their n papers have at least h citations each, 
and the other n − h papers have no more than h citations each.

If there are several possible values for h, the maximum one is taken as the h-index.
"""

# Time Complexity : O(n log n)
# Space Complexity : O(1)
# Did this code successfully run on leetcode : Yes
# Any problem you faced while coding this : No

from typing import List

class Solution:
    def hIndex(self, citations: List[int]) -> int:

        citations.sort()

        n = len(citations)
        
        for i in range(len(citations)):

            diff = n - i 

            if diff <= citations[i]:

                return diff

        return 0 

