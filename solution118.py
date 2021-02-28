#Time Complexity:O(n)
#Space Complexity:O(1)
#Approach: use 4 pointers left ,right, left wall and right wall to calculate the water trapped between buildings. Move the wall pointers and when necessary 
#use the left and right pointers to find the trapped amount of water and update result.
class Solution:
    def trap(self, height: List[int]) -> int:
        if len(height)==0:
            return 0
        n=len(height)
        result=0
        lw=rw=0
        l=0
        r=n-1
        while(l<=r):
            if lw<=rw:
                if height[l]<lw:
                    result+=lw-height[l]
                else:
                    lw=height[l]
                l+=1
            else:
                if height[r]<rw:
                    result+=rw-height[r]
                else:
                    rw=height[r]
                r-=1
        return result