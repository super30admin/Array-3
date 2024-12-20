"""
the array is not sorted in this case.
Appraoch1: what is the probable range of h-index. It would be a length of array.
In such cases, where we have range, we could use bucket sort.
In a hmap/array whose index represents the h-index and value is the  number of papers greater than that index.
THat is we want to know the count of elements in each bucket.
We do not need to exact sorted order, we need the count.
"""


class Solution:
    def hIndex(self, citations: List[int]) -> int:

        n = len(citations)
        bucket = [0 for _ in range(n + 1)]

        for el in citations:
            # the number of citations is greater than the max h_index
            # then it would go the max h_index
            if el >= n:
                bucket[n] += 1

            else:
                # there is one paper whose citation is equal to index of bucket array
                # increment its count.
                bucket[el] += 1

        total = 0
        # check in reverse order
        for i in range(len(bucket) - 1, -1, -1):
            total += bucket[i]
            if total >= i:
                return i


