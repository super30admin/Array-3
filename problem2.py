
#H-Index

# // Time Complexity :  O(N)
# // Space Complexity : O(n) - n is the length of the array
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


class Solution:
    def hIndex(self, citations: List[int]) -> int:
        countSum = [0]*(len(citations)+1)           
        
        for i in citations:                             #for every indices, increment if there are citations of it, it the citation is greater than the last element, add it to the last element
            if i>len(citations):
                countSum[-1]+=1
            else:
                countSum[i]+=1
        count=0
        for i in range(len(citations), -1,-1):          #traverse from the end and keep adding the count of them, when it reaches the index where count is greater than or equal to it, return the index
            count += countSum[i]
            if (count>=i):
                return i
        return 0