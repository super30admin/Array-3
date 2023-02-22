#time O(N)
#space O(N)
class Solution:
    def trap(self, height: List[int]) -> int:
        if len(height)==0:
            return 0
        left,right=[0]*len(height),[0]*len(height)
        ans=0
        left[0]=height[0]
        right[len(height)-1]=height[len(height)-1]
        for i in range(1,len(height)):
            left[i]=max(left[i-1],height[i])
        for i in range(len(height)-2,0,-1):
            right[i]=max(right[i+1],height[i])  
        for i in range(1,len(height)):
            ans+=min(left[i],right[i])-height[i]
        print(ans)
        return ans