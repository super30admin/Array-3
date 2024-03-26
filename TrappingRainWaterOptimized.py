'''
TC: O(n) - through the entries of input array
SC: O(1)
'''
from typing import List

class Solution:
    def trap(self, height: List[int]) -> int:
        leftwall,rightwall = height[0], height[-1]
        l,r = 0, len(height)-1
        ans = 0
        while l<=r:
            if leftwall<=rightwall:
                if height[l]>=leftwall:
                    leftwall = height[l]
                else:
                    ans += (leftwall-height[l])*1
                l+=1
            else:
                if height[r]>=rightwall:
                    rightwall = height[r]
                else:
                    ans += (rightwall-height[r])*1
                r -= 1
        return ans
s = Solution()
print(s.trap([0,1,0,2,1,0,1,3,2,1,2,1]))
print(s.trap([4,2,0,3,2,5]))