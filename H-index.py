"""
Runtime Complexity: O(n) - where 'n' is the length of the citations list.
Space Complexity: O(n) - we create a array of size 'n' to compute the solution.
Yes, the code worked on leetcode.
Issues while coding- No
"""

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        if n == 0:
            return 0
        arr = [0 for i in range(n+1)]
        for num in citations:
            if num > n:
                arr[n]+=1
            else:
                arr[num]+=1
        sum_ = 0 
        #print(arr)
        for i in range(n,-1,-1):
            sum_ = sum_+arr[i]
            if sum_>=i:
                return i
        nums[right] = temp
        