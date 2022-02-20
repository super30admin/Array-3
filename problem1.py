#Time and Space Complexity O(N)
class Solution:
    def trap(self, height: List[int]) -> int:
        if(height ==None or len(height)==0):
            return 0
        res = 0
        lw = 0
        l = 0
        r = len(height)-1
        rw =0

        while(l<=r):
            if(lw<=rw):
                if(lw>height[l]):
                    res += lw-height[l]
                else:
                    lw = height[l]
                l+=1
            else:
                if(rw>height[r]):
                    res+=rw-height[r]
                else:
                    rw = height[r]

                r-=1
        return res
