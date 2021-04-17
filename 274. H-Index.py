'''
T =O(NlogN)
S =O(1)

Appraoch:
Sort the citations,the hindex can varry from 0 to the max citations
find the no of different papers for every paper in the sorted array
Find a pair where the citations in more than the selected Hindex
that is the hindex
'''
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if not citations:
            return 0
        citations.sort()
        n = len(citations)
        for i in range(n):
            diff = n - i
            if diff <=  citations[i]:
                return diff
        return 0
        
        
'''
T = O(2n)
S = O(n)

Approach:
Create a binned array with the length equal to the lenght of the citations
Fill the values with zero initally and iterate over the citation array and increment the 
coresponding bins, if the value are grater than the length of the array then just add it to
the last bin.
Iterate the binned array from reverse by calculating the cumulative sum.The point at which the sum is more
or equal to the index is the hIndex.
'''

class Solution:
    def hIndex(self, citations: List[int]) -> int:
        if not citations:
            return 0
        nopapers = [0] * (len(citations)+1)
        
        for i in range(len(citations)):
            if citations[i] >= len(citations):
                nopapers[-1] += 1
            else:
                nopapers[citations[i]] += 1
            
        #print(nopapers)
        Sum = 0
        for i in range(len(nopapers)-1,-1,-1):
            Sum += nopapers[i]
            if Sum >= i:
                return i
        return 0