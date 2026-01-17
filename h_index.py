# https://leetcode.com/problems/h-index/
# Time Complexity- O(n) Space Complexity- O(n)

class Solution:
    def hIndex(self, citations):
        # find the length of the array
        n = len(citations)
        # initialise a new array to count a papers by their citation number
        count = [0] * (n + 1)
        
        # iterate through the citation array
        for c in citations:
            # check if citations exceed number of papers 
            if c >= n:
                count[n] += 1
            # keep the count of citation
            else:
                count[c] += 1

        # initialise a counter
        total = 0
        # we want largest value so used decremented for loop
        for i in range(n, -1, -1):
            # update the total
            total += count[i]
            # check if current i is valid h-index
            if total >= i:
                # return 
                return i
        # if no h-index found 
        return 0