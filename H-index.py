# // Time Complexity :O(nlogn)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :Yes 
# // Any problem you faced while coding this :NO
class Solution:
    def hIndex(self, c: List[int]) -> int:
        c.sort(reverse=True)
        if len(c)==1 and c[0]>0:
            return 1
        if c[-1]>=len(c):
            return len(c)
        for i in range(len(c)):
            if c[i]<i+1:
                return i
        return 0