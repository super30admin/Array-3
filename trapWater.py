'''
TC: O(n)
SC: O(1)
Leetcode: Sucess.
'''

class Solution:
    def trap(self, height: List[int]) -> int:
        if height == None or len(height) == 0:
            return 0
        
        n = len(height)
        leftmax = 0
        rightmax = 0
        l = 0
        r = n-1
        area = 0
        
        while(l < r):
            leftmax = max(leftmax, height[l])
            rightmax = max(rightmax, height[r])
            
            if leftmax < rightmax:
                area = area + (leftmax - height[l])
                l+=1
            else:
                area = area + (rightmax - height[r])
                r-=1
        return area
