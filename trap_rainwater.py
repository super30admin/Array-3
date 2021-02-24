"""
Time Complexity: O(n)
Space Complexity: O(1)
"""
class Solution:
    def trap(self, height: List[int]) -> int:
        if not height: return 0
        n = len(height)
        if n <= 2: return 0
        result = 0
        lwall = 0
        rwall = 0
        left = 0
        right = n-1
        
        while left <= right:
            if lwall < rwall:
                if lwall > height[left]:
                    result += 1 * (lwall-height[left])
                else:
                    lwall = height[left]
                left += 1
            else:    
                if rwall > height[right]:
                    result += 1 * (rwall-height[right])
                else:
                    rwall = height[right]
                right -= 1
            
        return result
