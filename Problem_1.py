"""
Problem : 1

Time Complexity : O(n)
Space Complexity : O(1)

Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

Approach - 1
Finding the wall with maximum height, so that it would guarentee the storage of water, and not overflow from both the sides
then starting one pointer, initializing the left wall with 0 to ensure the storage of water on the left side, whenever a smaller wall
is found, calculating the trapped water, if bigger wall found, it means water cannot be trapped, hence updating the left wall until the wall wit maximum height is found,
doing same from the other end, right end, of the array, and returning total trapped rain water

"""

# Trap Rain Water


# Approach - 1
# Two Pointer

class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        maxIdx=-1
        maxx=0
        result=0
        for i in range(len(height)):
            if maxx<height[i]:
                maxx=height[i]
                maxIdx=i

        lw=0
        for i in range(maxIdx):
            if height[i]<lw:
                result+=lw-height[i]
            else:
                lw=height[i]

        rw=0
        for i in range(len(height)-1,maxIdx,-1):
            if height[i]<rw:
                result+=rw-height[i]
            else:
                rw=height[i]

        return result

# Approach - 2
# Two Pointer

class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """

        # Approach - 1

        lw=0
        rw=0
        l=0
        r=len(height)-1
        result=0
        while l<=r:
            # check which wall is bigger
            if lw<=rw:
                # left side processing
                if lw>height[l]:
                    result+=lw-height[l]
                else:
                    lw=height[l]
                l+=1
            else:
                if rw>height[r]:
                    result+=rw-height[r]
                else:
                    rw=height[r]
                r-=1
        return result