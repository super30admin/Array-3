#Trap Rain Water 
# // Time Complexity :  O(N)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no



class Solution:
    def trap(self, height: List[int]) -> int:
        
        lw=0
        left=0
        rw=0
        right=len(height)-1
        res=0
        while(left<=right):                             
            if(lw<=rw):                                 #if left wall is greater than or equal to the right one, you know that you can trap water on the left side
                if(lw>height[left]):                    #if the left wall is higher than the height next to it, then you add the difference to the count
                    res+= lw-height[left]
                else:
                    lw=height[left]                     #if not, set the left height to the new height
                left+=1
            else:
                if(rw>height[right]):                   #if right wall is higher than height of the right index, you can add the trapped water to the count
                    res+=rw-height[right]
                else:
                    rw = height[right]                  #if not, set the right wall to the current height
                right-=1
        return res
                
        