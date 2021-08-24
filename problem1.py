class Solution:
    def trap(self, height: List[int]) -> int:
        #two pointers
        if len(height)<=2:
            return 0
        
        lw=0
        rw=0
        l=0
        r=len(height)-1
        res=0
        while(l<=r):
            
            if lw<=rw:
                if height[l]<lw:
                    res+=lw-height[l]
                else:
                    lw=height[l]
                l+=1
            else:
                if height[r]<rw:
                    res+=rw-height[r]
                else:
                    rw=height[r]
                r-=1
        return res
       #Time O(n)
       #Space O(1)
                
