class Solution:
    def hIndex(self, citations: List[int]) -> int:
        # Time, Space Complexity: O(n)
        # bucket sort
        x = [0 for i in range(0,len(citations)+1)]
        for i in citations:
            if(i>=len(citations)):
                x[-1]+=1
            else:
                x[i]+=1
        
        sum=0
        for i in range(len(x)-1,-1,-1):
            sum+=x[i]
            if(sum>=i):
                return i
        
        return 0
