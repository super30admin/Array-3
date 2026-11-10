# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using bucket sort. Initialize bucket with length of citations + 1
# Iterate over the citations and check if any element is greater than or equal to length of citations then we can put it in last bucket
# Else we can put it at that index if less than n
# Then iterate over the bucket in reverse order and add it to count
# If the count is greater than or equal to i then return i
# Return 0 if we dont find any i

class Solution:
    def hIndex(self, citations: list[int]) -> int:
        citations.sort()
        n = len(citations)
        for i in range(n):
            diff = n - i
            if citations[i] >= diff:
                return diff
        return 0
#Time - O(NlogN)
#Space - O(1)

class Solution:
    def hIndex(self, citations: list[int]) -> int:
        citations.sort()
        n = len(citations)
        left = 0
        right = n - 1
        while left <= right:
            mid = left + (right-left) // 2
            if citations[mid] >= n - mid:
                right = mid - 1
            else:
                left = mid + 1
        return n - left
#Time - O(NlogN)
#Space - O(1)


class Solution:
    def hIndex(self, citations: list[int]) -> int:
        n = len(citations)
        bucket = [0] * (n+1)
        for i in range(n):
            if citations[i] >= n:
                bucket[n] += 1
            else:
                bucket[citations[i]] += 1
        count = 0
        for i in range(len(bucket)-1, -1, -1):
            count += bucket[i]
            if count >= i:
                return i
        return 0
#Time - O(N)
#Space - O(N)
