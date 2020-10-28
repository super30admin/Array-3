# Time - O(N)
# Space - O(1)
# using 2 ointer left and right and taking left maximum and right maximum, getting area from it



class Solution:
    def trap(self, height: List[int]) -> int:
        
        area = 0
        leftMax = 0
        rightMax = 0
        
        left = 0
        right = len(height) - 1
        
        while(left<right):
            leftMax = max(leftMax, height[left])
            rightMax = max(rightMax, height[right])
            
            if leftMax < rightMax:
                area += leftMax - height[left]
                left += 1
            else:
                area += rightMax - height[right]
                right -= 1
        return area
