# // Time Complexity :O(n)
# // Space Complexity :O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach

class Solution:
    def trap(self, height: List[int]) -> int:
        print(height)
        result=0
        lw=0
        l=1
        rw=len(height)-1
        r=len(height)-2
        print(lw,rw,l,r)
        while(l<=r):
            if height[lw]<=height[rw]:
                if(height[lw]>height[l]):
                    result+=height[lw]-height[l]
                else:
                    height[lw]=height[l]
                l=l+1
            else:
                if(height[rw]>height[r]):
                    result+=height[rw]-height[r]
                else:
                    height[rw]=height[r]
                r=r-1
            print(result)
        return result
                