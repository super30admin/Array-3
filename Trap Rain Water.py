#Time Complexity : O(N)
#Space Complexity : O(1)
class Solution:
    def trap(self, height: List[int]) -> int:
        n = len(height)
        if(n==0):
            return 0
        l,r=0,n-1
        maxLeft,maxRight=height[l],height[r]
        temp=0
        res=0
        while(l<r):
            if(maxLeft<=maxRight):
                temp = maxLeft-height[l]
                l+=1 
                maxLeft = max(maxLeft,height[l])    
            else:
                temp = maxRight-height[r]
                r-=1
                maxRight = max(maxRight,height[r])
            if(temp>0):
                res+=temp
        return res


                


        