# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        #bucket sort technique
        bsort = [0] * (len(citations) + 1)
        for i in citations:
            if i >= len(citations):
                bsort[len(citations)] += 1
            else:
                bsort[i] += 1
        sum = 0
        for i in range(len(bsort)-1,-1,-1):
            sum += bsort[i]
            if sum >= i:
                return i
        
