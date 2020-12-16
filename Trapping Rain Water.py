# # Time:- O(n)
# # Space:- O(1)
# # Approach:- Using a left wall and right wall and a left pointer and right pointer the idea is to generalise the algorithm and think that if we have a left wall greater than right wall
# or right wall greater than left wall we can trap something between them. This something will be given by the left pointer with reference to the left wall and the right pointer with reference to the right wall.
class Solution(object):
    def trap(self, bars):
        """
        :type height: List[int]
        :rtype: int
        """
        lw,rw=0,len(bars)-1
        left,right=0,len(bars)-1
        res=0
        while left<=right:
            # if left wall is equal to the left pointer there is nothing to trap between them move left pointer
            if lw==left:
                left+=1
                continue
            # if right wall is equal to the right pointer there is nothing to trap between them move right pointer
            if rw==right:
                right-=1
                continue
            # if left wall is less than the left pointer this is an invalid scenario we should change the left wall
            if bars[lw]<bars[left]:
                lw=left
                continue
            # if right wall is less than the right pointer this is an invalid scenario we should change the right wall
            if bars[rw]<bars[right]:
                rw=right
                continue
            # if left wall is less than right wall we can definitely trap something something can be given with respect to the left pointer and the left wall
            if bars[lw]<=bars[rw] and bars[left]<=bars[lw]:
                res+=bars[lw]-bars[left]
                left+=1
                continue
            # if right wall is less than left wall we can trap something water trapped will be given by the lower wall which is the right wall and the right pointer
            elif bars[rw]<bars[lw] and bars[right]<bars[lw]:
                res+=bars[rw]-bars[right]
                right-=1
                continue
        return res