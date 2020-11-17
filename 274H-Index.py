# Time complexity - :- O(N log N  + log N)
# Space complexity :- O(1)
# Ran on Leetcode - Yes

# Any problems :- Still unclear about n-left logic

class Solution:

    def hIndex(self, citations: List[int]) -> int:
        
        citations.sort()
        
        n = len(citations)
        left = 0
        right = n - 1
        
        while (left <= right):
            
            mid = left + (right-left)//2
            
            if citations[mid] == n-mid:
                return n-mid
                
            elif citations[mid] < n - mid:
                left = mid + 1
            else:
                right = mid - 1
                
        return n - left