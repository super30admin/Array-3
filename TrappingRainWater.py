class Solution:
    def trap(self, height: List[int]) -> int:
        # Didn't understand the brute force solution
        
        lw = 0
        l = 0
        rw = 0
        r = len(height) - 1
        result = 0
        
        while l <= r:
            
            if lw <= rw:
                if lw > height[l]:
                    result += lw - height[l]
                else:
                    lw = height[l]
                    
                l += 1
            else:
                if rw > height[r]:
                    result += rw - height[r]
                else:
                    rw = height[r]
                r -= 1
                
        return result
    
# Time Complexity: O(n)
# Space Complexity: O(1)
