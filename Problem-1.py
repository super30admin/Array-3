'''
    Time Complexity: O(n)
    Space Complexity: O(1)
'''
class Solution:
    def trap(self, height: List[int]) -> int:
        n = len(height)
        left, right = 0, n-1
        lwIndex, rwIndex = 0, n-1
        result = 0

        while left <= right:
            if height[left] <= height[right]:
                if height[left] <= height[lwIndex]:
                    result += height[lwIndex] - height[left]
                else:
                    lwIndex = left
                
                left += 1

            else:
                if height[right] <= height[rwIndex]:
                    result += height[rwIndex] - height[right]
                else:
                    rwIndex = right
                
                right -= 1

        return result