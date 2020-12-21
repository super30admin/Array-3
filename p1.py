#Time; O(N)
#Space: O(1)
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
            if(lw<=rw):
                if(height[l]<lw):
                    res+=lw-height[l]
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
