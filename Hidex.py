'''
time complexity: O(n)
space complexity: O(n)
'''
class Solution:
    def hIndex(self, citations: List[int]) -> int:
        count = [0 for i in range(len(citations)+1)]
        n = len(citations)
        for i in range(len(citations)):
            if(citations[i]>=len(citations)):
                count[n]+=1
            else:
                count[citations[i]]+=1
                
        sums = 0
        
        for i in range(len(count)-1,-1,-1):
            sums+=count[i]
            if(sums>=i):
                return i