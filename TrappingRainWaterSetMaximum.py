'''
TC: O(2n)~O(n) where n is the number of input elements
SC: O(1)
'''
from typing import List

class Solution:
    def trap(self, height: List[int]) -> int:
        maxIdx = 0
        for i,h in enumerate(height):
            if h>height[maxIdx]:
                maxIdx = i

        #Set left_wall
        ans = 0
        leftwall = height[0]
        for i in range(0,maxIdx+1):
            if height[i]>leftwall:
                leftwall = height[i]
            else:
                ans += (leftwall-height[i])*1
        
        #Set right_wall
        rightwall = height[-1]
        for i in range(len(height)-1,maxIdx,-1):
            if height[i]>rightwall:
                rightwall = height[i]
            else:
                ans += (rightwall-height[i])*1
        return ans
s = Solution()
print(s.trap([0,1,0,2,1,0,1,3,2,1,2,1]))
print(s.trap([4,2,0,3,2,5]))