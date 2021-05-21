# Time Complexity: O(n)
# Space Complexity: O(n)
# Ran on Leetcode: Yes

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        arr = [0] * (n+1)
        for elem in citations:
            if elem > n:
                arr[n] += 1
            else:
                arr[elem] +=1 
        for i in range(n-1, -1, -1):
            arr[i] += arr[i + 1]
        
        for i in range(n, -1, -1):
            if arr[i] >= i:
                return i