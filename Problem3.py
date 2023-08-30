#Time Complexity :O(n)
#Space Complexity :O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def trap(self, height: List[int]) -> int:
        max_height=max(height)
        max_height_id=height.index(max_height)
        lw=0
        rw=0
        l=0
        r=len(height)-1
        result=0
        while(l<max_height_id):
            if lw>height[l]:
                result+=lw-height[l]
            else:
                lw=height[l]
            l+=1
        while(r>max_height_id):
            if rw>height[r]:
                result+=rw-height[r]
            else:
                rw=height[r]
            r-=1
        return result