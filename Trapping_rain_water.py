#Time Complexity: O(n)
#Space Complexity: O(1)

class Solution(object):
    def trap(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        maxindex = 0
        #Index where the maximum height
        for i in range(len(height)):
            if height[i] >= height[maxindex]:
                maxindex = i
        
        #from left to right
        lwall = 0
        wc = 0
        rwall = height[maxindex]
        for i in range(maxindex):
            if height[i] < lwall:
                wc += 1 * (lwall - height[i]) # leftwall will always be less than right wall so no need to take a minimum
            else:
                lwall = height[i]
        
        #from right to left
        i = len(height) - 1
        rwall = 0
        lwall = height[maxindex]
        while i > maxindex:
            if rwall > height[i]:
                wc += 1 * (rwall - height[i])
            else:
                rwall = height[i]
            i = i - 1
        return wc




        

            

        




        