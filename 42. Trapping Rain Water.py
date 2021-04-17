'''
T = O(n)
S = O(1)

Approach:
Maintain a leftWall value and RightWall value which will be used to check if there
can be a trapping wrt to the left and right pointers respectively,

First Check which wall is smaller and process that side.if the side pointer is smaller than
that side wall then it can be added to the result.If not then its not a valid trapping hence move the wall 
to the side of the pointer

Perform this action as long as both the pointers cross each other.

'''
class Solution:
    def trap(self, height: List[int]) -> int:
        if not height:
            return 0
        result = 0
        lWall = 0
        rWall = 0
        l = 0
        r = len(height) - 1
        
        while(l <= r):
            if lWall <= rWall:
                ## Process Left
                if height[l] <= lWall:
                    result += 1 * (lWall - height[l])
                else:
                    lWall = height[l]
                l += 1
            else:
                ## Process right
                if height[r] <= rWall:
                    result += 1 * (rWall - height[r])
                else:
                    rWall = height[r]
                r -= 1
        return result            