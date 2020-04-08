// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
In this problem we try to calculate the water level at each index.to do that we have to try to see the maximum left most height and we also check the maximum right and we take the minimum of both left and right and then subtract with the height at that index gives the water level at that index.

# Time complexity --> o(n)
# space complexity --> o(n)
class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        if height==None or len(height)==0:
            return 0
        llist=[0 for i in range(len(height))]
        rlist=[0 for i in range(len(height))]
        #calculating running left maxsum
        for i in range(1,len(height)):
            llist[i]=max(llist[i-1],height[i-1])
        #calculating running right maxsum
        for i in range(len(height)-2,-1,-1):
            rlist[i]=max(rlist[i+1],height[i+1])
        total=0
        for i in range(len(height)):
        #we take the min of left and right as water overflows if we take max of left and right
            mini=min(llist[i],rlist[i])
         #checking if there is a height at that index
            if mini>height[i]:
                total=total+(mini-height[i])
        return total