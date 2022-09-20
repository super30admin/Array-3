# Time complexity : O(n)
# Space complexity : O(len(n))
# Leetcode : Solved and submitted

class Solution:
    def hIndex(self, citations: List[int]) -> int:
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
