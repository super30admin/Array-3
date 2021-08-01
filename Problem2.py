# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


#take into buckets as the value of h-index will not cross the length of the Array
#count the number of papers in those buckets and check at what value the numbers cross
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if len(citations) == 0:
            return 0
        n = len(citations)
        
        buckets = [0]*(n+1)
        
        for i in citations:
            
            if i >= n:
                buckets[n] += 1
            else:
                buckets[i] += 1
        
        count = 0
        
        for i in range(n,-1,-1):
            count += buckets[i]
            
            if count >= i:
                return i
        return 0