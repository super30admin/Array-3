"""
TC=0(N)
SC=0(1)

process smaller wall side
trap water when the l or r pointer points to height smaller than its wall
else move the wall to l or r index resectively and repeat process


"""

class Solution:
    def trap(self, height: List[int]) -> int:
        if not height:
            return 0
        res=0
        n=len(height)
        
        lw=height[0]
        rw=height[n-1]
        
        l=0
        r=n-1
        
        while(l<=r):
            if(lw<=rw):#process smaller height wall side 
                if(height[l]<lw):
                    res+=lw-height[l] #trap water
                else:
                    lw=height[l]
                l+=1
            else:
                if(height[r]<rw):
                    res+=rw-height[r]
                else:
                    rw=height[r]
                r-=1
        return res
                    
        