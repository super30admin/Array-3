# Time Complexity : O(N log N) (Where N is length of total papers)
# Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english:
# - Sort the number in reverse order.
# - Than update the hindex with current index if numbers of ciattion is greater than or equal to current index.
# - Return hindex in the end.

class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
#       Sorted the number in reverse order
        citations.sort(reverse=True)
        hindex = 0
        
#       Loop over every value in list
        for i in range(len(citations)):
#           If citations are greater than current index than update hindex with current index
            if citations[i] >= i + 1:
                hindex = i + 1
#       Return hindex in the end
        return hindex
                
