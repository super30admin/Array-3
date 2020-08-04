# Time Complexity :if two arrays sorted average O(n)
# Space Complexity :O(n) 
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
class Solution(object):
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        # create buckets to see how many papers have how many citations
        helper = [0]*(len(citations)+1)
        # is citations is more than length of array add it to the last bucket else say that 1 or more papers have i citations
        for i in citations:
            helper[min(i,len(citations))] +=1
        #initiate sol
        sol = 0
        for i in range(len(citations),-1,-1):
            # move backwards in array until the number of papers are more than citations
            sol += helper[i]
            # then return i
            if sol >= i:
                return i
        # place holder
        return 7890