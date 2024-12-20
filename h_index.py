"""
there are two conditions to find the h index of the candidate. if h is the h index then:
(1) atleast h papers with citation >= h (2) (n (total papers) -h) papers with citation <= h. Note (2) will be
automatically satisfied.
Example: citations: [1, 2, 3, 4, 5, 6]
        h-index:     5  4  3  2  1  0  h-index 5,4, is not possible. We start from 5 because that is the max number
        possible
The citation array is sorted in increasing order. At the 0th index we check whether there are n =len(citations) papers
with  citations >= h-index. How? calculate the h-index at ith index: len(citations) - indx then compare it with the
value at that index h-index <= citations[idx] that is the h-index
brute force: initially h-index decreases with ciations the point where it becomes equal or less than that is the h-index
when h-index is 5 are there 5 papers with citations >= 5
TC: O(n)

Approach2: using binary search. We are searching for h-index and checking if it possible or not. when h-idx is equal to
value then found. If h-idx is greater then move right else move left  
"""


class Solution_approach1:
    def hIndex(self, citations: List[int]) -> int:

        citations = sorted(citations)
        n = len(citations)

        for i in range(n):
            # find the h-index at that index
            h_idx = n - i
            # compare with the value at idx
            if citations[i] >= h_idx:
                return h_idx

        return 0

class Solution_approach2:
    def hIndex(self, citations: List[int]) -> int:

        citations = sorted(citations)
        n = len(citations)

        for i in range(n):
            # find the h-index at that index
            h_idx = n - i
            # compare with the value at idx
            if citations[i] >= h_idx:
                return h_idx

        return 0

class Solution_binary_search:
    def hIndex(self, citations: List[int]) -> int:

        n = len(citations)
        lo = 0
        hi = n - 1
        # be consistent with the lo<=hi
        # start hi from the end index
        while lo <= hi:
            mid = lo + (hi - lo) // 2
            h_idx = n - mid  # 1 - 0
            if citations[mid] == h_idx:
                return h_idx

            # a lower value of h_idx is possible 
            elif citations[mid] > h_idx:
                hi = mid - 1
            else:
                lo = mid + 1

        # in the end, n-lo represents just a higher number
        return n - lo