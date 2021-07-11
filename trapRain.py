"""2. Trapping Rain Water
TC - O(N)
SC - O(1)"""
class Solution:
    def trap(self, height: List[int]) -> int:
        left =0
        right = len(height)-1
        
        leftmax = 0
        rightmax = 0
        
        if len(height)==0:
            return 0
        count =0
        while left<right:
            leftmax =max(leftmax,height[left])
            rightmax = max(rightmax, height[right])
            if leftmax < rightmax:
                count = count + leftmax - height[left]
                left += 1
            else:
                count = count + rightmax - height[right]
                right -= 1

        return count