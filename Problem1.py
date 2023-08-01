#Time complexity is: O(n)
#Space complexity is: O(1)
#No issues faced while coding
#Code ran successfully on leetcode

class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        #initializing the requried variables
        maxi=0
        maxi_ind=-1
        n=len(height)
        #Iterating through the array to find the maximum value and the index
        for i in range(0,n):
            if(height[i]>maxi):
                maxi=height[i]
                maxi_ind=i
        #Once we find the maximum heigh, we will divide the problem into 2 parts
        #left part -  initially we take left height as 0
        lw=0
        result=0
        #We will be iterating till maxi_ind
        for i in range(0,maxi_ind):
            #If the height[i] is less than leftwall, we will add the difference to the result value
            if(height[i]<lw):
                result+=lw-height[i]
            else:
                #Else we will assign height[i] to the left wall
                lw=height[i]
        #Right side
        rw=0
        #We will be iterating in the array from the right till the maximum index
        for i in range(n-1,maxi_ind,-1):
            #If the height at the index is less than right wall, we will add the subtracted value to the result
            if(height[i]<rw):
                result+=rw-height[i]
            #Else we will assign height at index i to the rw
            else:
                rw=height[i]
        #We will return result
        return result



        