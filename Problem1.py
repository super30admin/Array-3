# Trap Rain Water
# Time Complexity : O(N)
# Space Complexity : O(1)

class Solution:
    def trap(self, height: list[int]) -> int:
        n=len(height)
        max_val=0
        maxIndex=-1
        result=0

        for i in range(n):
            if max_val < height[i]:
                max_val=height[i]
                maxIndex=i
        l,lw=0,0
        while l<maxIndex:
            if height[lw]<height[l]:
                lw=l
            else:
                result+=height[lw]-height[l]
            l+=1

        r,rw=n-1,n-1
        while r>maxIndex:
            if height[rw]<height[r]:
                rw=r
            else:
                result+=height[rw]-height[r]
            r-=1
        
        return result