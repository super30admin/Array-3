# Time Complexity: O(n)
# Space Complexity: O(1)
class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        s=0
        f=1
        cT=0
        res=0
        while(f<len(height)):
            if(height[f]<height[s]):
                cT+=height[s]-height[f]
            else:
                res+=cT
                s=f
                cT=0
            
            f+=1
        print(res)        
        p=s
        cT=0
        s=len(height)-1
        f=s-1
        while(f>=p):
            if(height[f]<=height[s]):
                cT+=height[s]-height[f]
            else:
                res+=cT
                s=f
                cT=0
            f-=1
        return res

# Time Complexity: O(n)
# Space Complexity: O(1)
# Single pass
    # def trap(self, height):
    #     n=len(height)
    #     l=0
    #     r=n-1
    #     result=0
    #     lw=0
    #     rw=0
    #     while l<=r:
    #         if lw<=rw:
    #             if height[l]<lw:
    #                 result+=lw-height[l]
    #             else:
    #                 lw=height[l]
    #             l+=1
    #         else:
    #             if height[r]<rw:
    #                 result+=rw-height[r]
    #             else:
    #                 rw=height[r]
    #             r-=1
    #     return result