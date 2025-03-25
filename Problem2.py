# Problem 2 : H-Index
# Time Complexity : 
'''
Linear approach - O(n log n) where n is the length of the array
Bucket Sort - O(n log n) where n is the length of the array
'''
# Space Complexity : 
'''
Linear approach - O(1)
Bucket Sort - O(n) where n is the length of the nums array
'''
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this :
'''
None
'''

# Your code here along with comments explaining your approach
from typing import List
# linear search approach
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        # sort the citations array
        citations.sort()
        # get the length of the citations array
        length = len(citations)
        # loop through the length of the citations array
        for i in range(length):
            # get the difference between length of the array and ith position
            diff = length - i
            # check if the difference is less than the value at ith position of citattions array
            if diff <= citations[i]:
                # if it is then simply return the value of diff
                return diff
        # else return 0 if there is no h index in the array
        return 0
    
# Bucket Sort approach
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        # sort the citations array
        citations.sort()
        # get the length of the citations array
        length = len(citations)
        # define buckets array with the length of the citations array + 1
        buckets = [0] * (length+1)
        # loop through the length of the citations array
        for i in range(length):
            # if the value of citations array at ith position is greater than or equal to the length of the array
            if citations[i] >= length:
                # increment the value of buckets array at length position
                buckets[length] += 1
            else:
                # else increment the value at citation[i]th position of bucket array
                buckets[citations[i]] += 1
        # define the count and initialize the value as 0
        count = 0
        # loop through the array from length to 0 position ie. from end to start
        for i in range(length, -1, -1):
            # add the value of count and value at ith position in bucket
            count += buckets[i]
            # if the value of count is greater than or equal to i then return the i value
            if count >= i:
                return i
        # if there is no h index then return 0
        return 0
