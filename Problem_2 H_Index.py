# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode :
# // Any problem you faced while coding this :
#
#
# // Your code here along with comments explaining your approach

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        if citations == None or n ==0:
            return 0
        buckets = [0 for i in range(n+1)]
        for i in range(n):
            if citations[i] >= n:
                #Anything greater than the size of array, but it in the last bucket
                buckets[n] +=1
            else:
                #Esle put it in their respective buckets
                buckets[citations[i]] +=1
        sum_h = 0
        for i in range(n,-1,-1):
            #Iterate from Last and add the bucket values
            sum_h += buckets[i]
            if sum_h >= i:
                #When the sum value is greater than the index value, return the index
                return i
        return 1