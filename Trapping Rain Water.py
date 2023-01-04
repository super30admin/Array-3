class Solution:
    def trap(self, height: List[int]) -> int:
        
        lw, rw = 0, 0
        left = 0
        right = len(height) - 1
        result = 0

        while left <= right:
            if lw <= rw:
                if height[left] < lw:
                    result += lw - height[left]
                else:
                    lw = height[left]
                left+=1

            else:
                if height[right] < rw:
                    result += rw - height[right]
                else:
                    rw = height[right]
                right-=1

        return result
      
