class Solution:
    def trap(self, height: List[int]) -> int:
        # for i in range(len(height)-1):
        #     for j in range(i+1,len(height)):
        if height==None:
            return 0
        lw=l=0
        rw=r=len(height)-1
        result=0
        while l<=r:
            if height[lw]<height[rw]:
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
                #time-O(n) space-O(1)