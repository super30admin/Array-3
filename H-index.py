# Time Complexity: O(nlogn)
# Space Complexity: O(1)
# Brute Force Approach
class Solution(object):
    def hIndex(self, citations):
        if citations == None:
            return 0
        n = len(citations)
        citations.sort()
        
        for i in range(n):
            diff = n - i
            if diff <= citations[i]:
                return diff
        return 0



# Time complexity: O(n) - with Bucket sort
# Space complexity: O(1)
# Bucket Sort

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if citations == None:
            return 0
        n = len(citations)
        buckets = [0] * (n+1)
        for i in range(n):
            if citations[i] >= n:
                buckets[n] += 1
            else:
                buckets[citations[i]] += 1
            
        sum_count = 0
        for i in range(n, -1, -1):
            sum_count += buckets[i]
            if sum_count >= i:
                return i
        return 0
