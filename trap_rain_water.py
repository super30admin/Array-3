#Time Complexity -> O(n)
#Space complexity -> O(1)

class Solution:
    def trap(self, height: List[int]) -> int:
        
        #If height is None return 0
        if not height :
            return 0
        
        #point the left to left and right to end of the array
        l,r=0,len(height)-1
        
        #Initially maxleft and maxright will be the first elemts of l & r respectively
        maxleft,maxright=height[l],height[r]
        res=0
        
        #Iterate till we reach l==r
        while l<r:
            #If left is small move the left 
            if maxleft<maxright:
                l+=1
                maxleft=max(maxleft,height[l])
                res+=maxleft-height[l]
            
            #If right is small move the right 
            else:
                r-=1
                #update the max height accordingly
                maxright=max(maxright,height[r])
                #Add to the result the difference between the max and current height
                res+=maxright-height[r]
                
        
        return res
        