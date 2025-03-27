# Time O(2n)
# Space O(n)
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        arr = [0] * (n+1)
        for cite in citations[::-1]:
            if cite >= n:
                arr[-1] += 1
            else:
                arr[cite] += 1
        for i in range(n, -1, -1):
            if i != n:
                arr[i] += arr[i+1]
            if arr[i] >= i:
                return i
            
        return 0
# Time (n log n)
# Space O(n) sorting space of python    
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        citations.sort()
        n = len(citations)
        for i in range(n):
            diff = n - i
            if diff == citations[i] or diff < citations[i]:
                return diff
        return 0