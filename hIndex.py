# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        l = 0
        r = len(citations) - 1
        best = 0

        while l <= r:
            pivot = citations[l]

            i = l + 1
            for j in range(l + 1, r + 1):
                if citations[j] > pivot:
                    citations[i], citations[j] = citations[j], citations[i]
                    i += 1

            i -= 1
            citations[l], citations[i] = citations[i], citations[l]

            if citations[i] == i + 1:
                return i+1
            elif citations[i] > i + 1:
                l = i + 1
                best = i + 1
            else:
                r = i - 1

        return best
