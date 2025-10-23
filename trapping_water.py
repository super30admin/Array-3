class Solution:
    def trap(self, height: List[int]) -> int:
        n=len(height)
        lw,l=0,0
        rw,r=n-1,n-1
        result=0

        while l<=r:
            if height[rw]>height[lw]:
                if height[lw]>height[l]:
                    result+=height[lw]-height[l]
                else:
                    lw=l
                l+=1
            else:
                if height[rw]>height[r]:
                    result+=height[rw]-height[r]
                else:
                    rw=r
                r-=1
        return result
