'''
Time Complexity - O(n). We traverse the entire array once
Space Complexity - O(1). No additional variables being used

Works on leetcode.
'''
class Solution:
    def trap(self, height: List[int]) -> int:
        #maintain a left wall and right wall
        lw, rw = 0, 0
        #maintain the left and right pointers
        l, r = 0, len(height)-1
        result = 0
        #continue until l and r don't cross
        while l<=r:
            #if the left wall is greater than the right wall
            if lw < rw:
                #when the left wall is greater the left pointer add to result
                if lw > height[l]:
                    result+= lw - height[l]
                #when the height at the left pointer is greater we make it the left wall
                else:
                    lw = height[l]
                l+=1
            #if both walls are of same height or right wall is greater
            else:
                #we add to result the difference between both the walls if height at right is less than right wall

                if rw > height[r]:
                    result+=rw-height[r]
                #else we make the make the right pointer the right wall
                else:
                    rw = height[r]
                r-=1
        return result
