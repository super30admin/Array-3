class Solution:
    def trap(self, height: List[int]) -> int:
        """
        Solving using right and left pointers
        T: O(N)
        S: O(1)
        """
        if not height: return 0
        
        leftMax = 0
        rightMax = 0
        
        left = 0
        right = len(height) - 1
        
        area = 0
        
        while left < right:
            leftMax = max(leftMax, height[left])
            rightMax = max(rightMax, height[right])
            
            if leftMax < rightMax:
                area = area + leftMax - height[left]
                left += 1
            else:
                area = area + rightMax - height[right]
                right -= 1
        
        return area