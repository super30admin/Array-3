'''
Problem: H-Index
Time Complexity: O(n)
Space Complexity: O(n), for count sort array
Did this code successfully run on Leetcode: Yes
Any problem you faced while coding this: No
Your code here along with comments explaining your approach:
        Applied count sort to sort the array till the length of the citations
        traverse count array from end
        if total citations(currsum) exceeds the index then that index is the ans.
'''

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        n = len(citations)
        count = [0] * (n+1)
        currsum = 0

        for i in range(n):
            if citations[i]>n:
                count[n]+=1
            else:
                count[citations[i]]+=1

        for i in range(n, -1, -1):
            currsum += count[i]
            if currsum >= i:
                return i
        
        return 0