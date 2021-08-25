#Time Complexity: O(N)

#Space Complexity: O(1) 

class Solution:
    def trap(self, height: List[int]) -> int:
        
        n = len(height)
        
        if n==0 or n<=2:
            return 0
        lw = 0
        rw = 0
        l =0
        r = n-1
        result = 0
        while(l<=r):
            if lw<=rw:
                if height[l]<lw:
                    result+= 1 *(lw-height[l])
                else:
                    lw = height[l]
                l+=1
            else:
                if height[r]<rw:
                    result+= 1*(rw-height[r])
                else:
                    rw = height[r]
                r-=1
        return result
        