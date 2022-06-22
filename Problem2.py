#Time Complexity: O(NlogN)
#Space Complexity: O(1)
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        citations.sort()
        n = len(citations)
        start = 0
        high = n - 1
        
        while start <= high:
            mid = (start + high)//2
            if citations[mid] == n - mid:
                return citations[mid]
            elif citations[mid] < n - mid:
                start = mid + 1
            else:
                high = mid - 1
                
        return n - start