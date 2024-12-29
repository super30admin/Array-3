# Time: O(n) for 2pass 
# Space: O(n) for bucket arr
# Leetcode: Yes
# Issues: No

# 2 pass 
class Solution:
    def hIndex(self, citations: list[int]) -> int:
        n = len(citations)
        arr = [0]* (n+1)

        for i in citations:         # create a bucket of frequencies
            if i >= n:
                arr[-1] += 1
            else:
                arr[i]  += 1

        rsum = 0                    # running sum reverse
        for i in range(n,-1,-1):
            rsum += arr[i]
            if rsum >= i:
                return i

# nlogn binary search 1pass
class Solution:
    def hIndex(self, citations: list[int]) -> int:
        citations = sorted(citations)           # sort
        n = len(citations)
        low = 0
        high = n-1


        while low <= high:
            mid = low + (high-low)//2
            diff = n - (mid)                    # h index

            if diff == citations[mid]:          # found?
                return diff
            elif diff <= citations[mid]:
                high = mid-1
            else:
                low = mid+1

        return n-low                            # not found?







