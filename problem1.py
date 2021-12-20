#Time O(n), space O(1)
class Solution:
    def trap(self, height: List[int]) -> int:
        
        lm=0
        rm=0
        l=0
        h=len(height)-1
        w=0
        #Two pointer approach
        while l<=h:
            #for leftmax
            if height[l]<height[h]:
                if height[l]> lm:
                    lm=height[l]
                else:
                    w+=lm-height[l]
                l+=1
            
            #For right max
            else:
                
                if height[h]>rm:
                    rm=height[h]
                else:
                    w+=rm-height[h]
                h-=1
                
        return w
