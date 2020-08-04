"""
// Time Complexity : O(n), 
// Space Complexity : O(n), 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
"""
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if not citations:
            return 0
        n = len(citations)
        bucket = [0] * (n + 1) #use bucket sort, create a bucket with length 1 greater than the size of array to hold the out of range values
        
        
        for i in citations:
            if i >= n: #for out of range values, put at the last index
                bucket[n] += 1
            else:
                bucket[i] += 1
        ct = 0    
        for i in range(len(bucket) - 1, -1, -1): #start counting from the right end of bucket array, the index where the ct crosses is the H-index
            ct += bucket[i]
            
            if ct >= i:
                return i