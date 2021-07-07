'''
Solution:
1.  Use Bucket sort for this and number of buckets would be 0 - N as the H-Index range is the same.
2.  Place the number of papers achieved in each bucket and if citations >= N => place in the last bucket.
3.  From right, keep checking minimum number of papers greater than that index and return the first sign flip.

** Can also be solved by sorting and using Binary Search like the previous H-Index **
Time Complexity:    O(N)    |   Space Complexity:   O(N)
--- Passed all testcases on Leetcode successfully
'''

class Solution:
    def hIndex(self, citations: List[int]) -> int:

        #   edge case check
        if (citations == None or len(citations) == 0):
            return 0

        #   initializations
        n = len(citations)
        buckets = [0 for i in range(n + 1)]

        #   fill the buckets
        for citation in citations:
            if (citation > n):
                buckets[n] += 1
            else:
                buckets[citation] += 1

        #   running sum of minimum citations greater than current index from right to left
        citationsGreater = 0

        for i in range(n, -1, -1):
            citationsGreater += buckets[i]

            #   sign flip => return the index
            if (i <= citationsGreater):
                return i

        return 0