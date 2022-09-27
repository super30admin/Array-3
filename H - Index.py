class Solution:
    def hIndex(self, citations: List[int]) -> int:
        
        # TC: O(n)  Optimal Solution: Count Sort or Bucket Sort
        # SC : O(1)
        n = len(citations)
        
        buckets = [0 for _ in range(n+1)]
        
        for i in range(n):
            if citations[i] >= n:
                buckets[n] += 1
            else:
                buckets[citations[i]] += 1
                
        count = 0
        
        for i in range(n,-1,-1):
            count+= buckets[i]
            if count >= i:
                return i
        
        return 
        
        
        # TC: O(nlog n) Sort + Binary Search Solution 
        # SC : O(1)
        
#         low = 0
#         high = len(citations)-1
        
#         citations.sort()
        
#         while low <= high:
#             mid = low + (high-low)//2
#             diff = len(citations)- mid
#             if diff == citations[mid]:
#                 return diff
#             elif citations[mid] < diff:
#                 low = mid + 1
#             else:
#                 high = mid - 1
        
#         return len(citations) - low