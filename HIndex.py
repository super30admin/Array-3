class Solution:
    def hIndex(self, citations: List[int]) -> int:
        
        citations.sort()
        if len(citations) == 0:
            return 0
        
        n = len(citations)  
        
        for i in range(len(citations)):
            papers = n - i
            
            if papers <= citations[i]:
                return papers
                break
        return 0
    
    # Time Complexity: O(n logn) with sorting
    # Space Complexity: O(1)

# Time efficient space.
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        
        n = len(citations)
        arr = [0] * (n + 1) # O(n) space
        
        
        
        for i in range(n): #O(n) time
            if citations[i] > n:
                arr[-1] += 1
            else:
                arr[citations[i]] += 1
        print(arr)
        
        curr_sum = 0
        for i in range(n, -1, -1): # O(n) time
            curr_sum += arr[i]
            if curr_sum >= i:
                return i
            
            
        return 0
    
    # This is an approach using counting sort
    # Time Complexity: O(n)
    # Space Complexity: O(n) because extras space used