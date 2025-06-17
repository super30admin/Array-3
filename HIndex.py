# Optimized solution
# TC - O(n)
# SC - O(n)

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if citations is None or len(citations) == 0: return 0

        n = len(citations)

        nums = [0 for i in range(n + 1)]

        for i in range(n):
            if citations[i] > n:
                nums[n] += 1
            else:
                nums[citations[i]] += 1

        rSum = 0

        for i in range(n, -1, -1):
            rSum = rSum + nums[i]
            if rSum >= i:
                return i

        return 0
