"""
FAANMG Problem #118 {Medium} 

274. H-Index

#Time: O(nlogn)
#Space: O(1)

Did this code successfully run on Leetcode : Yes



@name: Rahul Govindkumar_RN27JUL2022
"""

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if citations == None or len(citations)==0:
            return 0
        
        n = len(citations)
        citations.sort()
        for i in range(n):
            
            diff = n - i
            print("\ni",i)
            print("citations[i]",citations[i])
            print("diff",diff)
            if diff <= citations[i]:
                return diff
            
        return 0        
    
    
 """
FAANMG Problem #118 {Medium} 

274. H-Index

# Time complexity : O(n)
# Space complexity : O(len(n))

Did this code successfully run on Leetcode : Yes



@name: Rahul Govindkumar_RN27JUL2022
"""   
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if citations == None or len(citations)==0:
            return 0

        n = len(citations)
        # creating a count sort list
        count = [0 for i in range(n+1)]
        for i in range(n):
            # for elements greater than n or equal to, update the count of nth index
            if citations[i] >= n:
                count[n] +=1 
            else:
                count[citations[i]] += 1
        # running sum is 0
        rSum = 0
        # startimg from the end
        for i in range(n,-1,-1):
            # we increment the sum with the count
            rSum += count[i]
            # at any point, we encounter equal to or greater than, return the index at that point
            if rSum >= i:
                return i