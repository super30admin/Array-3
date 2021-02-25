# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using bucket sort. Initialize bucket with length of citations + 1
# Iterate over the citations and check if any element is greater than or equal to length of citations then we can put it in last bucket
# Else we can put it at that index if less than n
# Then iterate over the bucket in reverse order and add it to sum
# If the sum is greater than or equal to i then return i
# Return 0 if we dont find any i


class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if not citations:
            return 0
        n = len(citations)
        bucket = [0] * (n + 1)
        sum = 0
        for i in range(len(citations)):
            if citations[i] >= n:
                bucket[n] += 1
            else:
                bucket[citations[i]] += 1

        for i in range(len(bucket) - 1, -1, -1):
            sum += bucket[i]
            if sum >= i:
                return i

        return 0