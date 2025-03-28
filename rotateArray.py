# Optimized solution
# TC - O(n)
# SC - O(n)

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if citations is None or len(citations) == 0: return 0

        n = len(citations)

        # create an array of len(n)
        nums = [0 for i in range(n + 1)]

        # add 1 to every nums array's index for citations[i]
        # if the value citations[i] > nums array's index, add 1 to the last index
        for i in range(n):
            if citations[i] > n:
                nums[n] += 1
            else:
                nums[citations[i]] += 1

        rSum = 0

        # here we traverse backwards
        # we calculate rSum and check if rSum is greater thancurr index
        for i in range(n, -1, -1):
            rSum = rSum + nums[i]
            if rSum >= i:
                return i

        return 0