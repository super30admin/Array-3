class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if citations is None or len(citations) == 0:
            return 0

        n = len(citations)
        # size of the list is 1 more than the citations
        # the extra element stores the count of the numbers bigger than n
        bucket = [0] * (n + 1)
        print(len(bucket))

        for i in range(n):
            if citations[i] >= n:
                bucket[n] = bucket[n] + 1
            else:
                bucket[citations[i]] += 1
        s = 0
        # loop from back to check number of citations on each index
        # as soon as the sum is same or more than the curr index
        # we return index as that is the H-index.
        for i in range(n, -1, -1):
            s += bucket[i]
            # print(s, bucket[i])
            if s >= i:
                return i

        return 0

# Bucket Sort
# Time Complexity: O(n)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No
