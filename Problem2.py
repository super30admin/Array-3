# I used counting sort approach and also sorted array approach to solve this problem.
# Time complexity is O(n) and space complexity is O(n) for counting sort approach.
# Time complexity is O(nlogn) and space complexity is O(1) for sorted array approach.

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        countarr = [0] * (len(citations) + 1)
        for i in citations:
            if i >= len(citations):
                countarr[len(countarr) - 1] += 1
            else:
                countarr[i] += 1
        sum = 0
        for i in range(len(citations), -1, -1):
            sum = sum + countarr[i]
            if sum >= i:
                return i

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        citations.sort()
        n = len(citations)
        l, r = 0, n
        while l < r:
            mid = (l + r + 1) // 2
            if citations[n - mid] >= mid:
                l = mid
            else:
                r = mid - 1
        return l