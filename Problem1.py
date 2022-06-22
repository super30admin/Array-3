#Time Complexity: O(N)
#Space Complexity: O(N)
class Solution:
    def trap(self, height: List[int]) -> int:
        low = 0
        right = len(height) - 1
        left_maxx = 0
        right_maxx = 0
        total = 0
        while low < right:
            if height[low] < height[right]:
                if height[low] > left_maxx:
                    left_maxx = height[low]
                else:
                    diff = left_maxx - height[low]
                    total += diff
                low +=1
                    
            else:
                if height[right] > right_maxx:
                    right_maxx = height[right]
                else:
                    diff = right_maxx - height[right]
                    total += diff
                right -=1
                    
        return total