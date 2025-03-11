#Time Complexity  - O(n)
#Space Complexity - O(1)
class Solution:
    def trap(self, height: List[int]) -> int:
        l ,r = 0 , len(height) -1
        res = 0
        leftmax = height[l]
        rightmax = height[r]
        while l < r:
            if leftmax < rightmax:
                l +=1
                leftmax =  max(leftmax,height[l])
                res += leftmax - height[l]
            else:
                r -= 1
                rightmax = max(rightmax,height[r])
                res += rightmax - height[r]
        return res
        