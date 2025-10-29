class Solution(object):
    # tc. : O(n) for bucket sort and again parsign to get the sum
    # sc : O(n), bucket array
    def hIndex(self, citations):
        """
        :type citations: List[int]
        :rtype: int
        """
        # our hindex wont be greater than, total number of papers and any citation greater than total number of papers are considered greater and no need to be sorted
        # only the elements from 0 to len of citations need to be sorted and rest can be considered the same value
        # so instead of sortign whoel array wil be bucket sort 
        # once bucket sorted will iteratre from the last and take sumation and check if the summation value is greater than the index and that's out hindex 

        # bucket sort
        n = len(citations)
        buckets = [0]*(n+1)

        for i in range(n):
             if citations[i] < n:
                buckets[citations[i]] +=1
             else:
                buckets[n] +=1

        sum = 0
        for i in range(n,-1,-1):
            sum += buckets[i]
            if sum >= i:
                return i
        
        return -1
