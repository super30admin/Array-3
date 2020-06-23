#Time Complexity O(N)
#Space complexity O(1)
'''
We notice that we can trap water if on both sides there's a larger wall, and
the water we can trap (given a length of 1) is the smallest wall 
of the 2 hight walls minus the height of the current position. Now, we
want to guarantee that there's a bigger wall on both side and. We move from both sides
while keeping track of the maximum wall encountered on both sides. Now if
the height on the left is smaller then height on the right, then we proceed with
the left side, since we have a guarantee that on the right there's always a higher wall.
The logic is the same for the other case.Now if the heighest left we've encountered is bigger than our current height,
then we know we can trap water, since both sides have a higher walls.If 
our current height, is higher then our previous highest left wall, then
we just update the highest left wall.
'''
class Solution:
    def trap(self, height: List[int]) -> int:
        left,right=0,len(height)-1
        max_left,max_right,res=0,0,0
        
        while left<right:
            if height[left]<height[right]:
                if height[left]<max_left:
                    res+=(max_left-height[left])
                max_left=max(max_left,height[left])
                left+=1
            else:
                if height[right]<max_right:
                    res+=(max_right-height[right])
                max_right=max(max_right,height[right])
                right-=1
                
        return res
