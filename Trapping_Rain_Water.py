class Solution:
    def trap(self, height: List[int]) -> int:
        
        l,r = 0,len(height)-1        
        lmax, rmax=0,0
        result = 0
        n = len(height)
        while l < r:
            if height[l] <= height[r]:
                if lmax <= height[l]:
                    lmax = height[l]
                else:
                    result += lmax- height[l]
                l +=1
                
            else:
                if rmax <= height[r]:
                    rmax = height[r]
                else:
                    result += rmax- height[r]
                r -=1
            
        
        return result
        
