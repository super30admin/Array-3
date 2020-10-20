
# Time- O(n)
# Space -O(1)
class Solution:
    def trap(self, height: List[int]) -> int:
        if len(height) < 3:
            return 0
        ans = 0
        left = 0
        right = len(height) - 1
        
        left_m = 0
        right_m = 0
        while left < right:
            left_m = max(left_m, height[left])
            right_m = max(right_m, height[right])
            
            if left_m < right_m:
                ans += left_m - height[left]
                left +=1
            else:
                ans += right_m - height[right]
                right -=1
                
        return ans