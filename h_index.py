class Solution(object):
    def hIndex(self, citations):
        citations.sort()        
        for i in range(len(citations)):
            tmp = len(citations) - i
            if tmp <= citations[i]:
                return tmp
        return 0
#Time-complexity: O(NlogN)
#Space-complexity: O(1)