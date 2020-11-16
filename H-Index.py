# TC: O(NlogN)
# SC: O(1)
# Yes, It ran on leetcode
# No problem

class Solution:
    def hIndex(self,citations) -> int:
        citations.sort()
        n = len(citations)
        left, right = 0, n
        
        while left < right:
            mid = left + (right - left) // 2
            if citations[mid] < n - mid:
                left = mid + 1
            else:
                right = mid

        return n - left