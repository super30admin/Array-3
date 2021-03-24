"""
42. Trapping Rain Water
Time Complexity - O(n)
Space Complexity - O(1)
We have a low and high pointer that will traverse till low < high and if value at index low is higher than min value change min value else calculate the sum and increment low else high is greater than max val chang max val or else calculate the sum in decrement high"""
class Solution:
    def trap(self, height: List[int]) -> int:
        if height == None or len(height) == 0:
            return 0
        low = 0
        high = len(height) - 1
        min_value = 0
        max_value = 0
        sum = 0
        while(low < high):
            if height[low] < height[high]:
                if height[low] >= min_value:
                    min_value = height[low]
                else:
                    sum += min_value - height[low]
                low += 1
            else:
                
                if height[high] >= max_value:
                    max_value = height[high]
                else:
                    sum += max_value - height[high]
                high -= 1
        return sum
        