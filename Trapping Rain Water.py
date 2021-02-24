class Solution:
    def trap(self, height: List[int]) -> int:
        if height==None or len(height)==0:
            return 0
        n=len(height)
        lw,rw=0,0
        l,r = 0,n-1
        A=0
        
        while l<=r:
            if lw<=rw:
                if lw<=height[l]:
                    lw=height[l]
                else:
                    A=A+lw-height[l]
                l+=1
                
            else:
                if rw<=height[r]:
                    rw=height[r]
                else:
                    A=A+rw-height[r]
                r-=1
               
        return A        
                
        
