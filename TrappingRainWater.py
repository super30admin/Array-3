
class Solution:
    def trap(self, height: List[int]) -> int:
        lftmax=0
        rhtmax=0
        lft=[]
        rht=[]
        water=[]
        for i in height:
            if i>=lftmax:
                lftmax=max(lftmax,i)
                lft.append(lftmax)
            else:
                lft.append(lftmax)
         
        for i in height[::-1]:
            if i>=rhtmax:
                rhtmax=max(rhtmax,i)
                rht.append(rhtmax)
            else:
                rht.append(rhtmax) 
        rht=rht[::-1]
        final=list(zip(lft,rht))
        for i in range(len(final)):
            water.append(min(final[i][0],final[i][1])-height[i])
        return sum(water)    
        
#time is O(n)
#space is O(1)
