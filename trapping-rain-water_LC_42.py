#TC:O(N) SC:O(1)
class Solution:
    def trap(self, height: List[int]) -> int:
        if height==None or len(height)==0:
            return 0
        total=0
        l=0
        r=len(height)-1
        lw=0
        rw=0

        while(l<=r):
            if lw<=rw:
                if lw>=height[l]:
                    total=total+lw-height[l]
                else:
                    lw=height[l]
                l+=1
            else:
                if rw>=height[r]:
                    total=total+rw-height[r]
                else:
                    rw=height[r]  
                r-=1
        return total                          
