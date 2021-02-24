#Time Complexity -- O(N)
#Space Complexitty -- O(1)

class Solution:
    def trap(self, height: List[int]) -> int:
        
        leftw = 0
        rightw = 0
        left = 0
        right = len(height)-1
        result = 0
        
        while(left <= right):
            if leftw <= rightw:
                if leftw < height[left]:
                    leftw = height[left]
                    left += 1
                        
                else:
                    result = result + (leftw - height[left])
                    left += 1
                    
                    
            else:
                if rightw < height[right]:
                    rightw = height[right]
                    right -= 1
                    
                else:
                    result = result + (rightw - height[right])
                    right -= 1
                    
        return result
