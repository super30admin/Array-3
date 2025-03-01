#time: O(n)
#space: O(1)
class Solution:
    def trap(self, height: List[int]) -> int:
        if len(height) == 0:
            return 0
        left=0
        lw=0
        right= len(height)-1
        rw=0
        total=0
        while( left <= right):
            if lw <= rw:
                if height[left] < lw:
                    total += (lw - height[left])
                else:
                    lw= height[left]
                left+=1
            else:
                if height[right] < rw:
                    total += (rw - height[right])
                else:
                    rw= height[right]
                right-=1
        return total
        
