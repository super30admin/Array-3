class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        #two pointer
        #O(n)
        #O(1)
        leftmax, rightmax = 0, 0
        left, right = 0, len(height)-1
        water = 0
        
        while left<right:
          
            if height[left] < height[right]:
                if height[left]>=leftmax: 
                    leftmax = height[left]
                #if leftmax is smaller, go towards inside level, chance to find more leftmax
                #new water level bounded by left building
                else:
                    water += leftmax-height[left]
                left+=1
            else:
                if height[right]>rightmax: 
                    rightmax = height[right]  
                else:
                    water += rightmax-height[right]
                right-=1
                
        return water  