#time complexity: O(n)
#space complexity: O(1)
#ran on leetcode: yes
#have two variables to track height of left and right wall. have 2 indexs to traverse from the start and end. if lw<rw, then lw-height[i] will give the water that can be held i current position. Similary vice versa we can caluclate for j when rw>lw.
class Solution:
    def trap(self, height: List[int]) -> int:
        s=0
        lw=0
        rw=0
        j=len(height)-1
        i=0
        while(i<j):
            lw=max(height[i],lw)
            rw=max(height[j],rw)
            if(lw<rw):
                if(height[i]<lw):
                    s+=lw-height[i]
                i+=1
            else:
                if(height[j]<rw):
                    s+=rw-height[j]
                j-=1
        return s

                

