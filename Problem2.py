## Problem2 H-Index (https://leetcode.com/problems/h-index/)

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if citations==None or len(citations)==0:
            return 0
        n = len(citations)
        buckets = [0 for x in range(n+1)] 
        for cite in citations:
            if cite>=n:
                buckets[n] = buckets[n]+1
            else:
                buckets[cite] = buckets[cite]+1
        rsum = 0
        for i in range(n,-1,-1):
            rsum = rsum +buckets[i]
            if rsum >= i:
                return i   
        return 0
        
#Time Complexity: O(n)
#Space Complexity: O(n)
#Approach: Create another array which has the size of the length of citations. Read the values of the citations array,
#  increment the value at that index which is equal to the value in citations array and if it exceeds the size then just 
# increment the last value in new array. Take a running sum and add the values 
# from the last in the new array comparing it to the index values there. if it is greater than or equal to the index value then return that index value. 