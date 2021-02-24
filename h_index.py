# Approach - Brute Force sort the array and solve similar to h_index_2
# Time - O( N log N)
# Space - O(1)

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        
        if not citations or len(citations) == 0:
            return 0
        
        
        citations.sort()
        
        for i in range(len(citations)):
            
            diff = len(citations) - i
            
            if diff <= citations[i]:
                return diff
            
        return 0
                
        
        
# Optimized Approach - Using Buckets stop once we reach the bounds of the array
# Time - O(N)
# Space - O(N) n is lenth of list

def hIndex(self, citations: List[int]) -> int:
        
        
        if not citations or len(citations) == 0:
            return 0
        
        n = len(citations)
        
        citations_sum = [0 for _ in range(n+1)]
        
        for citation in citations:
            if citation >= n:
                citations_sum[n] += 1
                
            else:
                citations_sum[citation] += 1
                
        total = 0
        
        for i in range(n, -1, -1):
            total += citations_sum[i]
            
            if total >= i:
                return i
            
        return 0