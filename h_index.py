# // Time Complexity :O(n)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach


class Solution:
    def hIndex(self, citations: List[int]) -> int:
        cita=[0 for i in range(len(citations)+1)]
        for i in citations:
            if i>=len(citations):
                cita[len(citations)]+=1
            else:
                cita[i]+=1
        print(cita)
        res=0
        for i in range(len(cita)-1,-1,-1):
            res+=cita[i]
            if i<=res:
                return i
            
            
        