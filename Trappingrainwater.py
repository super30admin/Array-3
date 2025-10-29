class Solution(object):
    def trap(self, height):
        # tc : O(n) 
        # sc : O(1)
        """
        :type height: List[int]
        :rtype: int
        """
        # water is trapped when there is a wall which is greater than the current height 
        # so will use two pointers from left and right and check the which height is smaller as we can stoee only that much water
        # and keep moving the pointers 

        left , right = 0, len(height)-1
        left_max, right_max = 0,0 # these will act the walls 
        ans = 0

        while left < right : # until we have explored all the heights
           if height[left] < height[right]: 
              left_max = max(left_max,height[left]) # every time we have to check whats the max height we have seen so far 
              ans += left_max - height[left] # water trapped
              left +=1 
           else:
                right_max = max(right_max, height[right]) # if right side is smaller then the water is trapped here
                ans += right_max - height[right]
                right -= 1
        
        return ans 
