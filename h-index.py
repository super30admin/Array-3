# Time Complexity : O(n) and 
# Space Complexity : O(n)

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        
        n = len(citations)
        
        # h-index range : 0 to n+1
        hIndex = [0] * (n+1)
        
        
        for i in range(n):
            # if value in citation is the largest value that is greater than n then include in the hindex last element and using cummulative sum , the previous indices will be automatically included.
            
            # update the last index only
            if citations[i] > n :
                hIndex[n] += 1
                
            # corresponding citation value in hidex hashset must be updated
            else: 
                print(citations[i])
                hIndex[citations[i]] += 1
        
        sumHindex = 0
        for i in range(n, -1, -1):
            sumHindex += hIndex[i]
            if (sumHindex >= i) :
                return i 
            
        
        return -1
            
        