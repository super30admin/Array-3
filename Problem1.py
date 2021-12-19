#rain water trapping
#time - O(n)
#space - O(n)
class Solution:
    def trap(self, height: List[int]) -> int:
        
        max_left = []
        max_right = [0] * len(height)
        
        maxLeft = 0
        maxRight = 0
        
        for h in height:
            if h > maxLeft:
                maxLeft = h
            max_left.append(maxLeft)
        
        
        for i in range(len(height)-1, -1, -1):
            
            h = height[i]
            if h > maxRight:
                maxRight = h
            
            max_right[i] = maxRight
        
        total = 0
        
        for i in range(len(max_left)):
            
            min_height = min(max_left[i], max_right[i])
            
            total = total + min_height - height[i]
        
        return total