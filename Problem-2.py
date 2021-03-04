#Time Complexity :o(n)
#Space Complexity :o(1)
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this :no

class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        if(height==None or len(height)<2):
            return 0
        
        lw,rw=0,0
        l=0
        r=len(height)-1
        ans=0
        while(l<=r):
            if(lw<=rw):
                if(lw>height[l]):
                    ans+=lw-height[l]
                else:
                    lw=height[l]
                l+=1
            else:
                if(rw>height[r]):
                    ans+=rw-height[r]
                else:
                    rw=height[r]
                r-=1
        return ans
        