class Solution:
    
    """
    Description: Trap rain water from non-negative array of building heights with unit width (2D)
    
    Time Complexity: O(n)
    Space Complexity: O(1)
    
    Approach: sliding window on both left and right side (2 x 2, 4 pointers)
    1. use left wall, and left pointer for left side, and similar for the right
    2. trap water when left wall or right wall is higher by evaluating the difference from current left or right pointer from the wall
    3. move left pointer to right and right pointer to left until they meet or cross each other
    """
    
    def trap(self, height: List[int]) -> int:
        
        if height == None or len(height) == 0: return 0
        
        l = 0; r = len(height) - 1
        lw = 0; rw = 0; result = 0
        
        while l <= r:
            if lw <= rw:
                if height[l] <= lw:
                    result += lw - height[l]
                else: lw = height[l]
                l += 1
            else:
                if height[r] <= rw:
                    result += rw - height[r]
                else: rw = height[r]
                r -= 1
                
        return result     
